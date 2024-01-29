package com.example.nejdndouitest.Repo;

import com.example.nejdndouitest.Models.Reservation;
import com.example.nejdndouitest.Models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByStatusOrderByTimereservationDesc(Status status);


}