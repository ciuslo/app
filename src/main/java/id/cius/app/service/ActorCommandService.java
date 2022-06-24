package id.cius.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorCommandService{

    @Autowired
    private ActorRepository  actorRepository;

    @Autowired
    private RedisTemplate<String, Actor> redisTemplate;

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ActorCommandService.class);

    public Actor simpan(Actor a){
        Actor savedActor = actorRepository.save(a);    
        if(savedActor.getId()!=null){
            redisTemplate.convertAndSend("searchEngine", savedActor);
        }    
        return savedActor;
    }

    @Autowired
    private KafkaTemplate<String, String> producer;

    @Autowired
    private NewTopic topic;

    public Actor add(Actor actor){
        Actor savedActor = actorRepository.save(actor);

        if(savedActor != null){
            if(savedActor.getId() > 0){
                // redisTemplate.convertAndSend(
                //         "search_engine", actor.toString());
                
                producer.send(topic.name(), actor.getId().toString(), new Gson().toJson(actor)).addCallback(
                        result -> {
                            // final RecordMetadata m;
                            if (result != null) {
//                                m = result.getRecordMetadata();
//                                logger.info("Produced record to topic {} partition {} @ offset {}",
//                                        m.topic(),
//                                        m.partition(),
//                                        m.offset());
                            }
                        },
                        exception -> logger.error("Failed to produce to kafka", exception));
            }
        }

        return savedActor;
    }

}