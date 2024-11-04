package com.drone.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "DeliveryOrder")
public class DeliveryOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String packageDetails;
    private String pickupLocation;
    private String deliveryLocation;
    private String status;
    private String location;
}
