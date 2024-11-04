package com.drone.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryOrderDto {
    private int id;
    private String packageDetails;
    private String pickupLocation;
    private String deliveryLocation;
    private String status;
    private String location;
}
