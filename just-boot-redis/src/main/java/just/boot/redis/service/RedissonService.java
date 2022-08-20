package just.boot.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Tenton Lien
 */
@Slf4j
@Service
public class RedissonService {

    @Resource
    private RedissonClient redissonClient;

    private static final String LOCK_KEY = "RESOURCE_KEY";

    public void tryLock() {
        RLock lock = redissonClient.getLock(LOCK_KEY);
        try {
            // 尝试加锁，最大等待时间5秒，上锁10秒自动解锁
            if (lock.tryLock(5, 10, TimeUnit.SECONDS)) {
                log.info("Lock success");
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            log.error("Lock failed: {}", e.toString());
        }
    }
}
