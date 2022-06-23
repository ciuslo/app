package id.cius.app.config;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.Topic;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;

import id.cius.app.model.Actor;
import id.cius.app.service.ActorBackgroundService;

@Configuration
public class RedisConfiguration {

    

    @Bean
    RedisTemplate<String, Actor> actorStringRedisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Actor> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        return template;
    }

    @Bean
    MessageListenerAdapter messageListener(ActorBackgroundService actorBackgroundService) {
        return new MessageListenerAdapter(actorBackgroundService);
    }

    @Bean
    RedisMessageListenerContainer redisContainer(RedisConnectionFactory connectionFactory, MessageListenerAdapter messageListenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(messageListenerAdapter, topic());
        return container;
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("searchEngine");
    }

}
