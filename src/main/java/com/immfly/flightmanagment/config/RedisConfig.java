/**
 * 
 */
package com.immfly.flightmanagment.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import com.immfly.flightmanagment.model.FlightData;

/**
 * @author akramkohansal
 *
 */
@Configuration
public class RedisConfig {

    @Value( "${spring.redis.host:127.0.0.1}" )
    private String redisUrl;
    
    @Value( "${redis.port:6379}" )
    private int redisPort;
    @Bean
    public JedisConnectionFactory jedisConnectionFactory() { 
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(redisUrl, redisPort); 
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }
   @Bean
    RedisTemplate<String, FlightData> redisTemplate() {
        RedisTemplate<String, FlightData> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
     }
}
