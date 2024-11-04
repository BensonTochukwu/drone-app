package com.drone.app.repo;

import com.drone.app.entity.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepo extends JpaRepository<Drone, Long> {

}
