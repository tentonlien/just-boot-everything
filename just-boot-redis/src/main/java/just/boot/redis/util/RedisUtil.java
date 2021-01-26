package just.boot.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

/**
 * @author Tenton Lien
 */
@Component
public class RedisUtil {
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
    public RedisUtil(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        RedisUtil.redisTemplate = redisTemplate;
    }

    public static boolean getLock(String key, String requestId, String expireTime) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/getLock.lua")));
        Object result = redisTemplate.execute(
                redisScript, argsSerializer, resultSerializer, Collections.singletonList(key), requestId, expireTime);
        return EXEC_RESULT.equals(result);
    }

    public static boolean releaseLock(String key, String requestId) {
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/releaseLock.lua")));
        Object result = redisTemplate.execute(redisScript, argsSerializer, resultSerializer, Collections.singletonList(key), requestId);
        if(EXEC_RESULT.equals(result)) {
            return true;
        }
        return false;
    }
}
