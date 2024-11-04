package com.drone.app.services;


import com.drone.app.entity.Drone;
import com.drone.app.exception.NotFoundException;
import com.drone.app.dto.DroneDto;
import com.drone.app.repo.DroneRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DroneService {

    private final DroneRepo droneRepo;

    public Drone addNewDrone(DroneDto droneReq){
        Drone drone = new Drone();
        drone.setBatteryLevel(droneReq.getBatteryLevel());
        drone.setLocation(droneReq.getLocation());
        return droneRepo.save(drone);
    }

        public ResponseEntity<Drone> updateDroneDetails(long id, DroneDto droneDto) {
            Optional<Drone> optionalDrone = droneRepo.findById(id);
            if (optionalDrone.isEmpty()) {

                throw new NotFoundException("Order with ID" + id + "not found");
            }
                Drone drone = optionalDrone.get();
                drone.setBatteryLevel(droneDto.getBatteryLevel());
                drone.setStatus(droneDto.getStatus());
                drone.setLocation(droneDto.getLocation());
                return new ResponseEntity<>(droneRepo.save(drone), HttpStatus.OK);
        }

    public Drone deleteDrone(Long id){
        if (droneRepo.existsById(id)) {
            droneRepo.deleteById(id);
        } else {
            throw new NotFoundException("Drone with ID " + id + " not found");
        }
        return droneRepo.getReferenceById(id);
    }

    public List<Drone> getAllDrones(){
        return droneRepo.findAll();
    }

    public Drone getDroneById(Long id){
        Optional<Drone> drone = droneRepo.findById(id);
        if (drone.isPresent()) {
            return drone.get();
        }
        throw new NotFoundException("Drone not found with ID: " + id);
    }
}
