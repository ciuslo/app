package id.cius.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import id.cius.app.model.Actor;

@Configuration
public class RedisConfiguration {
    
    @Bean
    RedisTemplate<Integer, Actor> actorRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Integer, Actor> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

   
    
    

}
