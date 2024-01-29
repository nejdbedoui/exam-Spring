package com.example.nejdndouitest.Repo;

import com.example.nejdndouitest.Models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}