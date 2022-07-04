package com.example.finalfas.worker.service;

import com.example.finalfas.shared.exception.ResourceNotFoundException;
import com.example.finalfas.worker.domain.model.entity.Request;
import com.example.finalfas.worker.domain.model.entity.Worker;
import com.example.finalfas.worker.domain.persistence.RequestRepository;
import com.example.finalfas.worker.domain.persistence.WorkerRepository;
import com.example.finalfas.worker.domain.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    private final static String ENTITY = "Request";

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private WorkerRepository workerRepository;

    @Override
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @Override
    public Request create(Request request, Long workerId) {
        Worker worker = workerRepository.findById(workerId)
                .orElseThrow(() -> new ResourceNotFoundException("Worker not found with Id" + workerId));
       request.setWorker(worker);
        return requestRepository.save(request);
    }

    @Override
    public ResponseEntity<?> delete(Long requestId) {
        return requestRepository.findById(requestId).map(request -> {
            requestRepository.delete(request);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, requestId));
    }

    @Override
    public List<Request> getByWorkerId(Long workerId) {
        return requestRepository.findByWorkerId(workerId);
    }
}