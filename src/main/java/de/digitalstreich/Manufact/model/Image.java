package de.digitalstreich.Manufact.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "path", nullable = false)
    private String path;

    @CreatedDate
    @Column(name = "created_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", columnDefinition = "DATETIME default CURRENT_TIMESTAMP")
    private Date updatedAt;

}
