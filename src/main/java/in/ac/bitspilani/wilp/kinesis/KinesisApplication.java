package in.ac.bitspilani.wilp.kinesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableBinding({Source.class, Sink.class})
@SpringBootApplication
public class KinesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(KinesisApplication.class, args);
    }
}
