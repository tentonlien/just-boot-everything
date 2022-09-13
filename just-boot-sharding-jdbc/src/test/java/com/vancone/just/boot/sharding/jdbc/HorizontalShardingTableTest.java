package com.vancone.just.boot.sharding.jdbc;

import com.vancone.just.boot.sharding.jdbc.entity.Order;
import com.vancone.just.boot.sharding.jdbc.mapper.OrderMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HorizontalShardingTableTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void createOrder() {
        for (int i = 0; i <= 10; i ++) {
            Order order = new Order();
            order.setId(i);
            order.setName(String.valueOf(i));
            orderMapper.insert(order);
        }
    }
}
