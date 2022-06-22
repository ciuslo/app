package id.cius.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import id.cius.app.model.Actor;
import id.cius.app.repository.ActorRepository;


@Service
public class ActorCommandService{

    @Autowired
    private ActorRepository  actorRepository;

    public Actor simpan(Actor a){
        return actorRepository.save(a);        
    }

  

}