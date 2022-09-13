package com.vancone.just.boot.sharding.jdbc.mapper;

import com.vancone.just.boot.sharding.jdbc.entity.Order;
import org.apache.ibatis.annotations.*;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO order(id, name, customer_id) VALUES(#{id}, #{name}, #{customer_id})")
    void insert(Order order);

    @Select("SELECT * FROM order WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "customerId", column = "customer_id")
    })
    Order selectOne(Integer id);
}
