package com.example.Translator.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;


@Configuration
@EnableCaching
public class RedisConfig {
      /*@Bean
      public RedisCacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        return RedisCacheManager.create(connectionFactory);
      }*/

      @Bean
      public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory){
          RedisTemplate<String,Object> redisTemplate=new RedisTemplate<>();
          redisTemplate.setKeySerializer(new StringRedisSerializer());
          redisTemplate.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
          redisTemplate.setConnectionFactory(factory);
          return redisTemplate;
      }
}
