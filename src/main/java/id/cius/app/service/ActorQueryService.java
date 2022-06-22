package id.cius.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorQueryService implements MessageListener{

    @Autowired
    private ActorRepository  actorRepository;

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

    @Override
    public void onMessage(Message arg0, byte[] arg1) {
        // TODO Auto-generated method stub
        
    }

}