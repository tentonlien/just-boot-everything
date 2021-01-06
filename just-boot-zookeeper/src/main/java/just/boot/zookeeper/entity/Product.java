package just.boot.zookeeper.entity;

import lombok.Data;

/**
 * @author Tenton Lien
 */
@Data
public class Product {
    private int id;
    private String name;
    private int price;
    private int amount;
}
