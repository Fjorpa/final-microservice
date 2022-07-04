package com.example.finalfas.worker.domain.persistence;

import com.example.finalfas.worker.domain.model.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    List<Request> findByWorkerId(Long workerId);
}
