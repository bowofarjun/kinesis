package in.ac.bitspilani.wilp.kinesis.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Order {
    private String id;
    private Category category;
    private String amount;
    private String ratings;
}
