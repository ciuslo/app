package id.cius.app.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import id.cius.app.model.Actor;

@Service
public class ActorBackgroundService implements MessageListener {

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ActorBackgroundService.class);

    @Autowired
    private StringRedisTemplate redisTemplate;


    @KafkaListener(topics = "#{'${io.confluent.developer.config.topic.name}'}",
    groupId = "actorJalan")
    public void consume(final ConsumerRecord<String, String> consumerRecord) {
        logger.info("received {} {}", consumerRecord.key(), consumerRecord.value());
    }

    @Override
    public void onMessage(Message message, byte[] patern) {
        String channel = new String(message.getChannel());
        switch (channel) {
            case "searchEngine":
                try {
                    fetchActor((Actor) deserialize(message.getBody()));
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }

    private void fetchActor(Actor a) {
        // logger.info("ACTOR "+a.getFirstName()+" "+a.getLastName());
        redisTemplate.opsForSet().add("name_"+a.getFirstName().substring(0, 2   ).toLowerCase(), new Gson().toJson(a));
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
