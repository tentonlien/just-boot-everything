package just.boot.mongodb;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.practice.redis.service.RedisService;

@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisTest {
    @Autowired
    private RedisService redisService;

    @Test
    public void test() {
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
        log.info(redisService.getString("level1:level2:111"));
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
        log.info(StringUtils.repeat('=', 50));
    }
}
