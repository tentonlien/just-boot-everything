package com.vancone.just.boot.sharding.jdbc.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private Integer id;
    private String name;
    private Integer customerId;
}
