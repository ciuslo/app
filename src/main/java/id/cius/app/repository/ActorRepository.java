package id.cius.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import id.cius.app.model.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
    
    List<Actor> findByFirstNameContainingIgnoreCase(String infix);
    List<Actor> findByLastNameContainingIgnoreCase(String infix);

}
