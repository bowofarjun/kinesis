package in.ac.bitspilani.wilp.kinesis.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import in.ac.bitspilani.wilp.kinesis.model.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class KinesisConsumer {

    private static final Logger logger = LoggerFactory.getLogger(KinesisConsumer.class);

    @StreamListener("input")
    public void input(String orderPayload) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Order order = objectMapper.readValue(orderPayload, Order.class);
            logger.info("Order with id {} is consumed successfully", order.getId());
        } catch (Exception ex) {
            logger.error("An error ocurred while reading or parsing the orderPayload {}", orderPayload);
        }
    }

}
