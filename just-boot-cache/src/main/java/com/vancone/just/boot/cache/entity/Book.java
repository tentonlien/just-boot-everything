package com.vancone.just.boot.cache.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Book {
    private String id;
    private String name;
    private BigDecimal price;
}
