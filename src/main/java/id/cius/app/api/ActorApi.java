package id.cius.app.api;
import id.cius.app.model.Actor;
import id.cius.app.service.ActorCommandService;
import id.cius.app.service.ActorQueryService;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/actor")
public class ActorApi {
   
    // @Autowired
    // private SessionFactory sessionFactory;

    @Autowired
    private ActorQueryService actorQueryService;

    @Autowired
    private ActorCommandService actorCommandService;


    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ActorApi.class);

    @RequestMapping("/index")
    public List<Actor> index(){
        return actorQueryService.getAll();
    }

    @RequestMapping("/search")
    public List<Actor> getActorById(String keyword){
        logger.info("message");
        // return actorQueryService.search(keyword);
        return actorQueryService.searchRedis(keyword);
    }

    @PostMapping("/")
    public Actor simpan(Actor actor){
        logger.info("message");
        return actorCommandService.simpan(actor);
    }
}