package just.boot.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.connection.RedisStringCommands;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.UUID;

/**
 * @author Tenton Lien
 */
@Component
public class SimpleLockUtil {
    private static RedisTemplate redisTemplate;
    private static DefaultRedisScript<Long> redisScript;
    private static RedisSerializer<String> argsSerializer;
    private static RedisSerializer resultSerializer;
    private static final Long EXEC_RESULT = 1L;

    @PostConstruct
    public void init() {
        redisScript = new DefaultRedisScript<>();
        redisScript.setResultType(Long.class);
        argsSerializer = new StringRedisSerializer();
        resultSerializer = new StringRedisSerializer();
    }

    @Autowired
    public SimpleLockUtil(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        SimpleLockUtil.redisTemplate = redisTemplate;
    }

    public static boolean lock(String key, String value, String expireTime) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/lock.lua")));
        Object result = redisTemplate.execute(
                redisScript, argsSerializer, resultSerializer, Collections.singletonList(key), value, expireTime);
        return EXEC_RESULT.equals(result);
    }

    public static boolean unlock(String key, String value) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/unlock.lua")));
        Object result = redisTemplate.execute(redisScript, argsSerializer, resultSerializer, Collections.singletonList(key), value);
        return EXEC_RESULT.equals(result);
    }
}
