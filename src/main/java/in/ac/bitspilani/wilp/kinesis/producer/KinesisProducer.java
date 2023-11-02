package in.ac.bitspilani.wilp.kinesis.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import in.ac.bitspilani.wilp.kinesis.model.Category;
import in.ac.bitspilani.wilp.kinesis.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Component
public class KinesisProducer {

    private static final Logger logger = LoggerFactory.getLogger(KinesisProducer.class);
    @Autowired
    private Source source;

    @Autowired
    private Order order;

    @Scheduled(fixedRateString = "${scheduler.fixedRate}")
    public void kinesisTestProducer() throws JsonProcessingException {
        generateRandomProduct();
        logger.info("Generated Order: \n {}", order);
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonPayload = objectMapper.writeValueAsString(order);

        logger.info("Started sending order to Kinesis with id {}", order.getId());
        try {
            source.output().send(MessageBuilder.withPayload(jsonPayload).build());
            logger.info("order record with id {} is prduced successfuly to Kinesis", order.getId());
        } catch (Exception ex) {
            logger.error("An error occurred while producing the order records to Kinesis {}", ex.getMessage());
        }
    }

    private void generateRandomProduct() {
        Random random = new Random();
        order.setAmount(String.format(Locale.US, "%.2f", random.nextDouble(1000.00)));
        order.setCategory(Category.values()[random.nextInt(Category.values().length)]);
        order.setId(UUID.randomUUID().toString());
        order.setRatings(String.format(Locale.US, "%.1f", random.nextDouble(5.00)));
    }
}
