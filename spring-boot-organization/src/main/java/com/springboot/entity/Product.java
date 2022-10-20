package com.springboot.entity;

import com.springboot.response.ProductDetails;
import lombok.*;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@ToString(exclude = {"productCategory", "productVariantList"})
public class Product extends ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sku")
    private String sku;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;

    @Column(name = "long_desc")
    @Type(type = "text")
    private String longDesc;

    @Column(name = "date_created", insertable = false)
    private Date dateCreated;

    @Column(name = "last_updated", insertable = false)
    @Type(type = "timestamp")
    private Date  lastUpdated;

    @Column(name = "unlimited")
    private Integer unlimited;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProductVariant> productVariantList;

}
