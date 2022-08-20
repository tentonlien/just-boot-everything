package just.boot.redis.lock;

import just.boot.redis.entity.SimpleLock2;
import just.boot.redis.util.SimpleLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisSimpleLock2Test {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void simpleLock() {
        boolean result = false;
        try(SimpleLock2 lock = new SimpleLock2(redisTemplate,"redisKey",20)) {
            if (lock.lock()) {
                log.info("Lock success");
                Thread.sleep(3000);
                result = true;
            }
        } catch (Exception e) {
            log.error("Lock failed: {}", e.toString());
        }
        Assert.assertTrue(result);
    }
}
