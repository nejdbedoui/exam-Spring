package com.example.nejdndouitest.Repo;

import com.example.nejdndouitest.Models.Status;
import com.example.nejdndouitest.Models.Type;
import com.example.nejdndouitest.Models.Washing_Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Washing_ServiceRepository extends JpaRepository<Washing_Service, Long> {
    @Query("""
            select w from Washing_Service w inner join w.reservations reservations
            where w.type = ?1 and reservations.status = ?2 and reservations.worker.name = ?3""")
    List<Washing_Service> findByTypeAndReservations_StatusAndReservations_Worker_Name(Type type, Status status, String name);

    List<Washing_Service> findByType(Type type);


}