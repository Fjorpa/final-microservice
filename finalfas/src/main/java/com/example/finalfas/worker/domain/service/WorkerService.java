package com.example.finalfas.worker.domain.service;

import com.example.finalfas.worker.domain.model.entity.Worker;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WorkerService {
    List<Worker> getAll();
    Worker create(Worker request);
    Worker update(Long workerId, Worker request);
    ResponseEntity<?> delete(Long workerId);

}
