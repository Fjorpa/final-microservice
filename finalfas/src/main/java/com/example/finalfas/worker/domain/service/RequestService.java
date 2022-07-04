package com.example.finalfas.worker.domain.service;

import com.example.finalfas.worker.domain.model.entity.Request;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface RequestService {
    List<Request> getAll();
    Request create (Request request, Long workerId);
    ResponseEntity<?> delete(Long requestId);
    List<Request> getByWorkerId (Long workerId);
}
