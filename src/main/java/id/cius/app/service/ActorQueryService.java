package id.cius.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorQueryService {

    @Autowired
    private ActorRepository  actorRepository;

    @Autowired
    private StringRedisTemplate redisTemplate;

    public List<Actor> getAll(){
        List<Actor> actors = actorRepository.findAll();
        // List<Actor> actorList = new ArrayList<>(actor);
        return actors;
        
    }

    public List<Actor> search(String keyword){
        List<Actor> actorsFirstName = actorRepository.findByFirstNameContainingIgnoreCase(keyword);
        List<Actor> actorsLastName = actorRepository.findByLastNameContainingIgnoreCase(keyword);

        return Stream.concat(actorsFirstName.stream(), actorsLastName.stream())
        .collect(Collectors.toList());

    }

    public List<Actor> searchRedis(String keyword){
        List<Actor> a = new ArrayList<>();
        List<String> r = new ArrayList<>(redisTemplate.opsForSet().members("name_"+keyword.substring(0, 2)));
        for (String string : r) {
            Actor ac = new Gson().fromJson(string, Actor.class);
            a.add(ac);
        }
        return a;

    }

   

}