package just.boot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author Tenton Lien
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public String getString(String key) {
        return redisTemplate.opsForValue().get(key);
//        return stringRedisTemplate.opsForValue().get(key);
    }



    public void setString(String key, String value) {
        stringRedisTemplate.opsForValue().set(key, value);
    }

    public String list() {
        String content = "";
        Set<String> keys = stringRedisTemplate.keys("*");
        for (String key : keys) {
            content += key + " = " + stringRedisTemplate.opsForValue().get(key) + "<br>";
        }
        return content;
    }

    public void setObject(Object object) {

    }
}
