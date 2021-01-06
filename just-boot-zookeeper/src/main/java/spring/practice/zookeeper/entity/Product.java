package spring.practice.zookeeper.entity;

import lombok.Data;

@Data
public class Product {
    private int id;
    private String name;
    private int price;
    private int amount;
}
