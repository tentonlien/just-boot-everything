package just.boot.mongodb.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Tenton Lien
 */
@Data
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private BigDecimal price;
    private int amount;
}
