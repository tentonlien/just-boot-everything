//package just.boot.redis.util;
//
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//
///**
// * @author Tenton Lien
// */
//@Component
//public class RedissonConnector {
//    RedissonClient redisson;
//
//    @PostConstruct
//    public void init() {
//        redisson = Redisson.create();
//    }
//
//    public RedissonClient getClient() {
//        return redisson;
//    }
//}
