package de.digitalstreich.Manufact.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", columnDefinition = "text", nullable = false)
    private String name;

    @Column(name = "slug", unique = true, nullable = false)
    private String slug;

    @Column(name = "product_number", nullable = false, unique = true)
    private String productNumber;

    @Column(name = "price")
    private Double price;

    @Column(name = "height")
    private Double height;

    @Column(name = "length")
    private Double length;

    @Column(name = "depth")
    private Double depth;

    @Column(name = "volume")
    private Double volume;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "ean", unique = true)
    private String ean;

    @Column(name = "delivery_time")
    private String deliveryTime;

    @Column(name = "packaging_unit")
    private String packaging_unit;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "description", columnDefinition = "text")
    private String description;


    @Nullable
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"),
            foreignKey = @ForeignKey(name = "fk_product_category"),
            inverseForeignKey = @ForeignKey(name = "fk_category_product"))
    private List<Category> categories;

    @Nullable
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "products_tags",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"),
            foreignKey = @ForeignKey(name = "fk_product_tag"),
            inverseForeignKey = @ForeignKey(name = "fk_tag_product")
    )
    private List<Tag> tags;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_manufacturer_product"),
            name = "product_manufacturer_id"
    )
    private Manufacturer manufacturer;

    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime  updatedAt;

    public Product(Long id, String name, String productNumber, Double price, Manufacturer manufacturer)
    {
        this.id = id;
        this.name = name;
        this.productNumber = productNumber;
        this.price = price;
        this.manufacturer = manufacturer;
    }


    public Product(String name, String productNumber, Double price, Double height, Double length, Double depth, Double volume, Double weight, String ean, String deliveryTime, String packaging_unit, Date publicationDate, String description, Manufacturer manufacturer) {
        this.name = name;
        this.slug = createSlug(name);
        this.productNumber = productNumber;
        this.price = price;
        this.height = height;
        this.length = length;
        this.depth = depth;
        this.volume = volume;
        this.weight = weight;
        this.ean = ean;
        this.deliveryTime = deliveryTime;
        this.packaging_unit = packaging_unit;
        this.publicationDate = publicationDate;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    private String createSlug(String name) {
        String slug = name.toLowerCase(Locale.GERMAN);
        slug = slug
                .replace("ä", "ae")
                .replace("ö", "oe")
                .replace("ü", "ue")
                .replace(" ", "-");
        return slug;
    }
}
