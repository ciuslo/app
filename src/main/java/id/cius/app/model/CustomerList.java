// package id.cius.app.model;

// import org.hibernate.annotations.Immutable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Lob;
// import javax.persistence.Table;

// @Entity
// @Immutable
// @Table(name = "customer_list")
// public class CustomerList {
//     @Column(name = "id")
//     private Integer id;

//     @Lob
//     @Column(name = "name")
//     private String name;

//     @Column(name = "address", length = 50)
//     private String address;

//     @Column(name = "\"zip code\"", length = 10)
//     private String zipCode;

//     @Column(name = "phone", length = 20)
//     private String phone;

//     @Column(name = "city", length = 50)
//     private String city;

//     @Column(name = "country", length = 50)
//     private String country;

//     @Lob
//     @Column(name = "notes")
//     private String notes;

//     @Column(name = "sid")
//     private Integer sid;

//     public Integer getId() {
//         return id;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public String getZipCode() {
//         return zipCode;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public String getCity() {
//         return city;
//     }

//     public String getCountry() {
//         return country;
//     }

//     public String getNotes() {
//         return notes;
//     }

//     public Integer getSid() {
//         return sid;
//     }

//     protected CustomerList() {
//     }
// }