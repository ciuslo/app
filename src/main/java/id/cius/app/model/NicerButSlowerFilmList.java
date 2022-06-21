// package id.cius.app.model;

// import org.hibernate.annotations.Immutable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Lob;
// import javax.persistence.Table;
// import java.math.BigDecimal;

// @Entity
// @Immutable
// @Table(name = "nicer_but_slower_film_list")
// public class NicerButSlowerFilmList {
//     @Column(name = "fid")
//     private Integer fid;

//     @Column(name = "title")
//     private String title;

//     @Lob
//     @Column(name = "description")
//     private String description;

//     @Column(name = "category", length = 25)
//     private String category;

//     @Column(name = "price", precision = 4, scale = 2)
//     private BigDecimal price;

//     @Column(name = "length")
//     private Integer length;

//     @Lob
//     @Column(name = "actors")
//     private String actors;

//     public Integer getFid() {
//         return fid;
//     }

//     public String getTitle() {
//         return title;
//     }

//     public String getDescription() {
//         return description;
//     }

//     public String getCategory() {
//         return category;
//     }

//     public BigDecimal getPrice() {
//         return price;
//     }

//     public Integer getLength() {
//         return length;
//     }

//     public String getActors() {
//         return actors;
//     }

//     protected NicerButSlowerFilmList() {
//     }
// /*
//   TODO [JPA Buddy] create field to map the 'rating' column
//    Available actions: Define target Java type | Uncomment as is | Remove column mapping
//   @Column(name = "rating", columnDefinition = "mpaa_rating")
//   private Object rating;
// */
// }