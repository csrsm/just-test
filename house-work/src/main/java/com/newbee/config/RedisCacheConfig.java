//package com.newbee.config;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// * redis
// */
//@Configuration
//@EnableCaching
//public class RedisCacheConfig extends CachingConfigurerSupport {
//    Logger logger = LoggerFactory.getLogger(RedisCacheConfig.class);
//    @Autowired
//    private RedisProperties redisProperties;
//    @Value("${redis.cache.expiration:3600}")
//    private Long expiration;
//
//    @Bean
//    public JedisPool redisPoolFactory() {
//        logger.info("JedisPool注入成功！！");
//        logger.info("redis地址：" + redisProperties.getHost() + ":" + redisProperties.getPort());
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, redisProperties.getHost(), redisProperties.getPort(), redisProperties.getTimeout(), redisProperties.getPassword());
//        return jedisPool;
//    }
//
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        RedisCacheManager rcm = new RedisCacheManager(redisTemplate);
//        rcm.setDefaultExpiration(expiration);
//        return rcm;
//    }
//
//    @Bean
//    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
//        RedisTemplate<String, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(factory);
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        return template;
//    }
//}
