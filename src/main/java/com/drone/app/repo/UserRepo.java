package com.drone.app.repo;

import com.drone.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUserName(String userName);
    Optional<Users> findByEmail(String email);
}
