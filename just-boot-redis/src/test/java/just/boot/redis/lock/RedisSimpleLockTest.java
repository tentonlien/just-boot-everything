package just.boot.redis.lock;

import just.boot.redis.util.SimpleLockUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisSimpleLockTest {

    @Test
    public void simpleLock() {
        Assert.assertTrue(SimpleLockUtil.lock("key", "requestId", "30"));
    }

    @Test
    public void simpleUnlock() {
        Assert.assertTrue(SimpleLockUtil.unlock("key", "requestId"));
    }
}
