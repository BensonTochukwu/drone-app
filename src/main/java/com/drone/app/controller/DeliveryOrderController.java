package com.drone.app.controller;

import com.drone.app.entity.DeliveryOrder;
import com.drone.app.dto.DeliveryOrderDto;
import com.drone.app.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class DeliveryOrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("create")
    public ResponseEntity<DeliveryOrder> createOrder(@RequestBody DeliveryOrderDto deliveryOrder){
        DeliveryOrder deliveryOrder1 =  orderService.addNewOrder(deliveryOrder);
        return new ResponseEntity<>(deliveryOrder1, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<DeliveryOrder> updateOrder(@PathVariable Long id, @RequestBody DeliveryOrderDto update){
        return orderService.updateOrder(id, update);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>deleteOrder(@PathVariable Long id){
        DeliveryOrder deliveryOrder = orderService.deleteOrder(id);
        return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value =  {"/all"})
    public List<DeliveryOrder> getAllOrders(){
    return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryOrder> getOrderById(@PathVariable Long id) {
        DeliveryOrder order = orderService.getOrderById(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
