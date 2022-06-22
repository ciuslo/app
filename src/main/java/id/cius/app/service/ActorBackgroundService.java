package id.cius.app.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;

@Service
public class ActorBackgroundService implements MessageListener {

    @Autowired
    private StringRedisTemplate redisTemplate;
    
    public static List<String> messageList = new ArrayList<String>();


    
    @Override
    public void onMessage(Message message, byte[] patern) {
        messageList.add(message.toString());
        System.out.println("Message received: " + message.toString());

        String channel = new String(message.getChannel());
        System.out.println("channel "+channel);
        // ByteArrayInputStream inputStream = new ByteArrayInputStream(message.getBody());
        
        // try {
        //     actor = (Actor) new ObjectInputStream(inputStream).readObject();
        // } catch (ClassNotFoundException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // } catch (IOException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        switch (channel){
            case "searchEngine":
                fetchActor(new String(message.getBody()));
                break;
            default : break;
        }
    }

    private void fetchActor(String a) {
        redisTemplate.opsForSet().add("arg0", a);
    }

    
}
