package id.cius.app.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorQueryService {

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

   

}