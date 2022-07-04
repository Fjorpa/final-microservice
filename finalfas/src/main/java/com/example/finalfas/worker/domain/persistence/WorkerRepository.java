package com.example.finalfas.worker.domain.persistence;

import com.example.finalfas.worker.domain.model.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
