package de.digitalstreich.Manufact.model;

import de.digitalstreich.Manufact.model.auth.User;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
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
    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
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

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    @OneToMany(mappedBy = "manufacturer")
    private List<Productgroup> productgroups;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(
            name = "manufacturer_details_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_manufacturer_details")
    )
    private ManufacturerDetails manufacturerDetails;


    public Manufacturer(Long id, String company, String website, String ustid, String postcode, String city, String street, String contactEmail, Boolean active, String phone, User user, Branch branch, Country country, State state) {
        this.id = id;
        this.company = company;
        this.website = website;
        this.ustid = ustid;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.contactEmail = contactEmail;
        this.active = active;
        this.phone = phone;
        this.user = user;
        this.branch = branch;
        this.country = country;
        this.state = state;
    }

    public Manufacturer(String company, String website, String ustid, String postcode, String city, String street, String contactEmail, Boolean active, String phone, User user, Branch branch, Country country, State state) {
        this.company = company;
        this.website = website;
        this.ustid = ustid;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.contactEmail = contactEmail;
        this.active = active;
        this.phone = phone;
        this.user = user;
        this.branch = branch;
        this.country = country;
        this.state = state;
    }
}
