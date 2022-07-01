package just.boot.mongodb.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Tenton Lien
 */
@Data
@Document
public class Customer {
    private String name;
    private String address;
    private int age;
}
