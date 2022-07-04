package com.example.finalfas.worker.api;

import com.example.finalfas.worker.domain.service.WorkerService;
import com.example.finalfas.worker.mapping.WorkerMapper;
import com.example.finalfas.worker.resource.CreateWorkerResource;
import com.example.finalfas.worker.resource.UpdateWorkerResource;
import com.example.finalfas.worker.resource.WorkerResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Worker")
@RestController
@RequestMapping("/api/v1/workers")
@CrossOrigin
public class WorkerController {

    @Autowired
    private WorkerService workerService;

    @Autowired
    private WorkerMapper mapper;

    @GetMapping
    public List<WorkerResource> getAllWorkers()
    {
        return mapper.toResource(workerService.getAll());
    }

    @PostMapping
    public WorkerResource createWorker(@RequestBody CreateWorkerResource request)
    {
        return mapper.toResource(workerService.create(mapper.toModel(request)));
    }

    @PutMapping("{workerId}")
    public WorkerResource updateWorker(@PathVariable Long workerId, @RequestBody UpdateWorkerResource request)
    {
        return mapper.toResource(workerService.update(workerId, mapper.toModel(request)));
    }

    @DeleteMapping("{workerId}")
    public ResponseEntity<?> deleteWorker(@PathVariable Long workerId)
    {
        return workerService.delete(workerId);
    }
}