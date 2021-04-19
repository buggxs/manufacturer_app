package de.digitalstreich.Manufact.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "productgroups")
@NoArgsConstructor
@Getter
@Setter
public class Productgroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "released")
    private Boolean released = false;

    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime  updatedAt;

    @Nullable
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "productgroups_products",
            joinColumns = @JoinColumn(name = "productgroup_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"),
            foreignKey = @ForeignKey(name = "fk_productgroup_product"),
            inverseForeignKey = @ForeignKey(name = "fk_product_productgroup"))
    private List<Product> products;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_manufacturer_productgroup"),
            name = "manufacturer_id"
    )
    private Manufacturer manufacturer;

    @Nullable
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinTable(
            name = "productgroups_retailers",
            joinColumns = @JoinColumn(name = "productgroup_id"),
            inverseJoinColumns = @JoinColumn(name = "retailer_id"),
            foreignKey = @ForeignKey(name = "fk_productgroup_retailer"),
            inverseForeignKey = @ForeignKey(name = "fk_retailer_productgroup")
    )
    private List<Retailer> retailerList;

    public Productgroup(String name, String description, @Nullable List<Product> products, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.products = products;
        this.manufacturer = manufacturer;
    }

    public Productgroup(String name, String description, Boolean released, @Nullable List<Product> products, Manufacturer manufacturer, @Nullable List<Retailer> retailerList) {
        this.name = name;
        this.description = description;
        this.released = released;
        this.products = products;
        this.manufacturer = manufacturer;
        this.retailerList = retailerList;
    }
}
