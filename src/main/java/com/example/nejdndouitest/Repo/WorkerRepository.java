package com.example.nejdndouitest.Repo;

import com.example.nejdndouitest.Models.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
    Worker findByNic(String nic);

}