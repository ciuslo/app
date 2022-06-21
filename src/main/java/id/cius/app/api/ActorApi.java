package id.cius.app.api;
import id.cius.app.model.Actor;


import java.util.List;

import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/actor")
public class ActorApi {
   
    @Autowired
    private SessionFactory sessionFactory;

    Logger logger = org.apache.logging.log4j.LogManager.getLogger(ActorApi.class);

    @RequestMapping("/index")
    public List<Actor> index(){
        return sessionFactory.createEntityManager()
            .createQuery("from Actor", Actor.class).getResultList();
    }

    @RequestMapping("/by")
    public List<Actor> getActorById(@RequestParam("id") int id){
        logger.info("message");
        return sessionFactory.createEntityManager()
            .createQuery("from Actor where id = :id", Actor.class)
            .setParameter("id", id)
            .getResultList();
    }
}