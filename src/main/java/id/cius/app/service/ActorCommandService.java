package id.cius.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorCommandService{

    @Autowired
    private ActorRepository  actorRepository;

    @Autowired
    private RedisTemplate<Integer, Actor> redisTemplate;

    public Actor simpan(Actor a){
        Actor savedActor = actorRepository.save(a);    
        if(savedActor.getId()!=null){
            redisTemplate.convertAndSend("searchEngine", savedActor);
        }    
        return savedActor;
    }

  

}