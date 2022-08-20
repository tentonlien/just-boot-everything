package just.boot.redis.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.data.redis.core.types.Expiration;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Slf4j
public class SimpleLock2 implements AutoCloseable {

    private RedisTemplate redisTemplate;
    private String key;
    private String value;
    //单位：秒
    private int expireTime;

    public SimpleLock2(RedisTemplate redisTemplate, String key, int expireTime) {
        this.redisTemplate = redisTemplate;
        this.key = key;
        this.expireTime = expireTime;
        this.value = UUID.randomUUID().toString();
    }

    public boolean lock() {
        RedisCallback<Boolean> redisCallback = connection -> {
            RedisStringCommands.SetOption setOption = RedisStringCommands.SetOption.ifAbsent();
            Expiration expiration = Expiration.seconds(expireTime);
            byte[] redisKey = redisTemplate.getKeySerializer().serialize(key);
            byte[] redisValue = redisTemplate.getValueSerializer().serialize(value);
            Boolean result = connection.set(redisKey, redisValue, expiration, setOption);
            return result;
        };
        return (boolean) redisTemplate.execute(redisCallback);
    }

    public boolean unlock() {
        String script = "if redis.call(\"get\",KEYS[1]) == ARGV[1] then\n" +
                "    return redis.call(\"del\",KEYS[1])\n" +
                "else\n" +
                "    return 0\n" +
                "end";
        RedisScript<Boolean> redisScript = RedisScript.of(script, Boolean.class);
        List<String> keys = Arrays.asList(key);
        return (boolean) redisTemplate.execute(redisScript, keys, value);
    }

    @Override
    public void close() {
        unlock();
    }
}
