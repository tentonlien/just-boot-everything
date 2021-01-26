package just.boot.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

/**
 * @author Tenton Lien
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    private DefaultRedisScript<List> getRedisScript;

    @PostConstruct
    public void init() {
        getRedisScript = new DefaultRedisScript<>();
        getRedisScript.setResultType(List.class);
        getRedisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/test.lua")));
    }

    public void execute() {
        List<String> keyList = new ArrayList<>();
        keyList.add("count");
        keyList.add("rate.limiting:127.0.0.1");

        Map<String, Object> argvMap = new HashMap<>();
        argvMap.put("expire", 10000);
        argvMap.put("times", 10);

        List result = redisTemplate.execute(getRedisScript, keyList, argvMap);
        System.out.println(result);
    }


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
