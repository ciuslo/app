package id.cius.app.service;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class ActorBackgroundService implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] patern) {
        String channel = new String(message.getChannel());
        switch (channel){
            case "searchEngine":
                fetchActor(message);
                break;
        }
    }

    private void fetchActor(Message message) {
    }

    
}
