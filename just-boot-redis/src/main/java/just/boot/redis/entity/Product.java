package just.boot.redis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Tenton Lien
 */
@Data
public class Product implements Serializable {
    private int id;
    private String name;
    private int price;
    private int amount;
}
