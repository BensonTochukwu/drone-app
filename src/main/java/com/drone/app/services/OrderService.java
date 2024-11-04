package com.drone.app.services;

import com.drone.app.entity.DeliveryOrder;
import com.drone.app.exception.NotFoundException;
import com.drone.app.dto.DeliveryOrderDto;
import com.drone.app.repo.DeliveryOrderRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final DeliveryOrderRepo deliveryOrderRepo;

    public DeliveryOrder addNewOrder(DeliveryOrderDto deliveryOrderReq) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();
        deliveryOrder.setPackageDetails(deliveryOrderReq.getPackageDetails());
        deliveryOrder.setPickupLocation(deliveryOrderReq.getPickupLocation());
        deliveryOrder.setDeliveryLocation(deliveryOrderReq.getDeliveryLocation());
        deliveryOrder.setLocation(deliveryOrderReq.getLocation());
        return deliveryOrderRepo.save(deliveryOrder);
    }

    public ResponseEntity<DeliveryOrder> updateOrder(Long id, DeliveryOrderDto deliveryOrderDto) {
        Optional<DeliveryOrder> optionalDeliveryOrder = deliveryOrderRepo.findById(id);
        if (optionalDeliveryOrder.isEmpty()){

            throw new NotFoundException("Order with ID " + id + " not found");
        }
            DeliveryOrder deliveryOrder = optionalDeliveryOrder.get();
            deliveryOrder.setPackageDetails(deliveryOrderDto.getPackageDetails());
            deliveryOrder.setPickupLocation(deliveryOrderDto.getPickupLocation());
            deliveryOrder.setLocation(deliveryOrderDto.getLocation());
            deliveryOrder.setDeliveryLocation(deliveryOrderDto.getDeliveryLocation());

            return new ResponseEntity<>(deliveryOrderRepo.save(deliveryOrder), HttpStatus.OK);
    }

    public DeliveryOrder deleteOrder(Long id){
        if (deliveryOrderRepo.existsById(id)) {
            deliveryOrderRepo.deleteById(id);
        } else {
            throw new NotFoundException("Order with ID " + id + " not found");
        }
        return deliveryOrderRepo.getReferenceById(id);
    }

    public List<DeliveryOrder> getAllOrders(){
        return deliveryOrderRepo.findAll();
    }

    public DeliveryOrder getOrderById(Long id){
        Optional<DeliveryOrder> deliveryOrder = deliveryOrderRepo.findById(id);
        if (deliveryOrder.isPresent()){
            return deliveryOrder.get();
        }
        throw new NotFoundException("Order with ID " + id + " not found");
    }
}