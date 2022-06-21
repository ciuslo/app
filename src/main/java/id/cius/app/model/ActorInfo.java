// package id.cius.app.model;

// import org.hibernate.annotations.Immutable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Lob;
// import javax.persistence.Table;

// @Entity
// @Immutable
// @Table(name = "actor_info")
// public class ActorInfo {
//     @Column(name = "actor_id")
//     private Integer actorId;

//     @Column(name = "first_name", length = 45)
//     private String firstName;

//     @Column(name = "last_name", length = 45)
//     private String lastName;

//     @Lob
//     @Column(name = "film_info")
//     private String filmInfo;

//     public Integer getActorId() {
//         return actorId;
//     }

//     public String getFirstName() {
//         return firstName;
//     }

//     public String getLastName() {
//         return lastName;
//     }

//     public String getFilmInfo() {
//         return filmInfo;
//     }

//     protected ActorInfo() {
//     }
// }