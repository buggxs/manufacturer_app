package de.digitalstreich.Manufact.model;

import de.digitalstreich.Manufact.model.auth.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "manufacturers")
@Getter
@Setter
@NoArgsConstructor
public class Manufacturer {

    @Id
    @Column(name = "user_id")
    private Long id;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "website", columnDefinition = "text", unique = true)
    private String website;

    @Column(name = "ustid", columnDefinition = "varchar(12)", unique = true)
    private String ustid;

    @Column(name = "postcode", columnDefinition = "varchar(5)")
    private String postcode;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "contact_email", unique = true, nullable = false)
    private String contactEmail;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "phone")
    private String phone;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @OneToOne
    @MapsId
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_user")
    )
    private User user;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "branch_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_branch")
    )
    private Branch branch;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "country_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_country")
    )
    private Country country;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "state_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_state")
    )
    private State state;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(
            foreignKey = @ForeignKey(name = "fk_manufacturer_product")
    )
    private List<Product> products;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "manufacturer_details_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_details")
    )
    private ManufacturerDetails manufacturerDetails;

}
