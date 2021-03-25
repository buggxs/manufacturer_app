package de.digitalstreich.Manufact.model;

import javax.persistence.*;

@Entity
@Table(name = "manufacturer_details")
public class ManufacturerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "warehousing")
    private Boolean warehousing;

    @Column(name = "delivery")
    private Boolean delivery;

}
