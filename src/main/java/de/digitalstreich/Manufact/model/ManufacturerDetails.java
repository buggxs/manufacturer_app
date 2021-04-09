package de.digitalstreich.Manufact.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer_details")
@Getter
@Setter
@NoArgsConstructor
public class ManufacturerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "warehousing")
    private Boolean warehousing;

    @Column(name = "delivery")
    private Boolean delivery;

    public ManufacturerDetails(Boolean warehousing, Boolean delivery) {
        this.warehousing = warehousing;
        this.delivery = delivery;
    }
}
