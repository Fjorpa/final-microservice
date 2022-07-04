package com.example.finalfas.worker.service;

import com.example.finalfas.shared.exception.ResourceNotFoundException;
import com.example.finalfas.worker.domain.model.entity.Worker;
import com.example.finalfas.worker.domain.persistence.WorkerRepository;
import com.example.finalfas.worker.domain.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService {

    private final static String ENTITY = "Worker";
    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Worker> getAll() {
        return workerRepository.findAll();
    }

    @Override
    public Worker create(Worker request) {
        return workerRepository.save(request);
    }

    @Override
    public Worker update(Long workerId, Worker request) {
        return workerRepository.findById(workerId).map(worker ->
                        workerRepository.save(worker.withRole(request.getRole())
                                .withSpecialty(request.getSpecialty())
                        )).orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }

    @Override
    public ResponseEntity<?> delete(Long workerId) {
        return workerRepository.findById(workerId).map(worker -> {
            workerRepository.delete(worker);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, workerId));
    }
}

