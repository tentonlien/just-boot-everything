//package just.boot.redis.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.scripting.support.ResourceScriptSource;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author Tenton Lien
// * @since 2022/08/20
// */
//@Service
//public class TransactionService {
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    public int executeLuaScript () {
//        // Redis脚本对象
//        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
//        //设置返回值类型
//        redisScript.setResultType(Long.class); // 设置返回类型
//        // 这里处理传resource也可以传文本,一般情况下建议传一个constant string进来，不需要每次走IO读取文件，也可以将resource缓存q起来
//        // redisScript.setScriptText("xxxx");
//        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("RedisTest.lua")));
//
//        // 设置lua脚本文件路径
//        List<Object> keys = new ArrayList<>(); // lua脚本中所有的KEY
//        keys.add("TEST-LUA1");
//
//        // 缓存类型根据具体情况而定
//        redisTemplate.opsForValue().set("TEST-LUA1", 0);
//        Long executeObj = redisTemplate.opsForValue()
//                .getOperations()
//                .execute(redisScript, keys, 60, "1");
//        System.out.println(executeObj);
//
//        assert executeObj != null;
//        return executeObj.intValue();
//    }
//}
