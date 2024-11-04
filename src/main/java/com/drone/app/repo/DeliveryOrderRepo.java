package com.drone.app.repo;

import com.drone.app.entity.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderRepo extends JpaRepository<DeliveryOrder, Long> {
}
