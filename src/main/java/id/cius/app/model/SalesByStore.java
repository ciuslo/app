// package id.cius.app.model;

// import org.hibernate.annotations.Immutable;

// import javax.persistence.Column;
// import javax.persistence.Entity;
// import javax.persistence.Lob;
// import javax.persistence.Table;
// import java.math.BigDecimal;

// @Entity
// @Immutable
// @Table(name = "sales_by_store")
// public class SalesByStore {
//     @Lob
//     @Column(name = "store")
//     private String store;

//     @Lob
//     @Column(name = "manager")
//     private String manager;

//     @Column(name = "total_sales")
//     private BigDecimal totalSales;

//     public String getStore() {
//         return store;
//     }

//     public String getManager() {
//         return manager;
//     }

//     public BigDecimal getTotalSales() {
//         return totalSales;
//     }

//     protected SalesByStore() {
//     }
// }