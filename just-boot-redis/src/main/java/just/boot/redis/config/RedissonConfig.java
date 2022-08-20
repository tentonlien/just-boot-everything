//package just.boot.redis.config;
//
//import lombok.Data;
//import org.apache.commons.lang3.StringUtils;
//import org.redisson.Redisson;
//import org.redisson.api.RedissonClient;
//import org.redisson.config.Config;
//import org.redisson.config.SingleServerConfig;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Data
//@Configuration
//@ConfigurationProperties(prefix = "redisson")
//public class RedissonConfig {
//    private int timeout = 3000;
//    private String schema = "redis://";
//    private String address;
//    private String password;
//    private int connectionPoolSize = 64;
//    private int connectionMinimumIdleSize = 10;
//    private int slaveConnectionPoolSize = 250;
//    private int masterConnectionPoolSize = 250;
//    private String[] sentinelAddresses;
//    private String masterName;
//
//    /*测试时mock使用*/
//    /*@Bean
//    RedissonClient redissonSingle() {
//        RedissonClient redissonClient = Mockito.mock(RedissonClient.class);
//        return redissonClient;
//    }*/
//
//    /**
//     * 单机模式
//     */
//    @Bean
//    RedissonClient redissonSingle() {
//        Config config = new Config();
//        SingleServerConfig serverConfig = config.useSingleServer()
//                .setAddress(address)
//                .setTimeout(timeout)
//                .setConnectionPoolSize(connectionPoolSize)
//                .setConnectionMinimumIdleSize(getConnectionMinimumIdleSize());
//        if (StringUtils.isNotBlank(password)) {
//            serverConfig.setPassword(password);
//        }
//        return Redisson.create(config);
//    }
//
//    /**
//     * 哨兵模式
//     * @return
//     */
////    @Bean
////    RedissonClient redissonSentinel() {
////        Config config = new Config();
////
////        // 拼接协议
////        String[] sentinelAddressesWithSchema = new String[sentinelAddresses.length];
////        for (int i = 0; i < sentinelAddresses.length; i++) {
////            sentinelAddressesWithSchema[i] = schema + sentinelAddresses[i];
////        }
////
////        SentinelServersConfig serversConfig = config.useSentinelServers()
////                .setMasterName(masterName)
////                .addSentinelAddress(sentinelAddressesWithSchema)
////                .setMasterConnectionPoolSize(masterConnectionPoolSize)
////                .setSlaveConnectionPoolSize(slaveConnectionPoolSize)
////                .setMasterConnectionMinimumIdleSize(getConnectionMinimumIdleSize())
////                .setSlaveConnectionMinimumIdleSize(getConnectionMinimumIdleSize());
////
////        if (StringUtils.isNotBlank(password)) {
////            serversConfig.setPassword(password);
////        }
////        return Redisson.create(config);
////    }
//}