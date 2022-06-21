// package id.cius.app.model;

// import org.hibernate.annotations.Immutable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Table;
// import java.math.BigDecimal;

// @Entity
// @Immutable
// @Table(name = "sales_by_film_category")
// public class SalesByFilmCategory {
//     @Column(name = "category", length = 25)
//     private String category;

//     @Column(name = "total_sales")
//     private BigDecimal totalSales;

//     public String getCategory() {
//         return category;
//     }

//     public BigDecimal getTotalSales() {
//         return totalSales;
//     }

//     protected SalesByFilmCategory() {
//     }
// }