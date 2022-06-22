package id.cius.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import id.cius.app.model.Actor;
import id.cius.app.service.ActorBackgroundService;

@Configuration
public class RedisConfiguration {

    @Bean
    RedisTemplate<Integer, Actor> actorRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Integer, Actor> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new ActorBackgroundService());
    }

}
