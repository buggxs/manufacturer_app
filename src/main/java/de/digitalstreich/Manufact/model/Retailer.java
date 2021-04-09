package de.digitalstreich.Manufact.model;

import de.digitalstreich.Manufact.model.auth.User;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "retailers")
public class Retailer {

    @Id
    @Column(name = "user_id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(
            name = "user_id",
            foreignKey = @ForeignKey(name = "fk_retailer_user")
    )
    private User user;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date updatedAt;

}
