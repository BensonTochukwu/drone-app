package com.drone.app.controller;

import com.drone.app.entity.Drone;
import com.drone.app.dto.DroneDto;
import com.drone.app.services.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @PostMapping("create")
    public ResponseEntity<Drone> createDrone(@RequestBody DroneDto drone) {
        Drone droneApp = droneService.addNewDrone(drone);
        return new ResponseEntity<>(droneApp, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable Long id, @RequestBody DroneDto update) {
        return droneService.updateDroneDetails(id, update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrone(@PathVariable Long id) {
        Drone droneApp = droneService.deleteDrone(id);
        return new ResponseEntity<>("Drone deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = {"/all"})
    public List<Drone> getAllDrones(){
        return droneService.getAllDrones();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drone>getDroneById(@PathVariable Long id){
        Drone drone = droneService.getDroneById(id);
        return new ResponseEntity<>(drone, HttpStatus.OK);
    }

}

