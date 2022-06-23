package id.cius.app.service;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;

@Service
public class ActorBackgroundService implements MessageListener {

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ActorBackgroundService.class);

    public static List<String> messageList = new ArrayList<String>();

    @Autowired
    private RedisTemplate<String, Actor> redisTemplate;

    @Override
    public void onMessage(Message message, byte[] patern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());

        String channel = new String(message.getChannel());
        System.out.println("channel " + channel);

        switch (channel) {
            case "searchEngine":
                logger.debug("MASUK SINI");
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
        logger.info("ACTOR "+a.getFirstName()+" "+a.getLastName());
        redisTemplate.opsForSet().add("arg0", a);
    }

    public static Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream in = new ByteArrayInputStream(data);
        ObjectInputStream is = new ObjectInputStream(in);
        return is.readObject();
    }
}
