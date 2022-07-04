package com.example.finalfas.worker.mapping;

import com.example.finalfas.shared.mapping.EnhancedModelMapper;
import com.example.finalfas.worker.domain.model.entity.Worker;
import com.example.finalfas.worker.resource.CreateWorkerResource;
import com.example.finalfas.worker.resource.UpdateWorkerResource;
import com.example.finalfas.worker.resource.WorkerResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class WorkerMapper {
    @Autowired
    private EnhancedModelMapper mapper;

    public WorkerResource toResource(Worker model)
    {
        return mapper.map(model, WorkerResource.class);
    }

    public List<WorkerResource> toResource(List<Worker> model)
    {
        return mapper.mapList(model, WorkerResource.class);
    }

    public Worker toModel(CreateWorkerResource resource)
    {
        return mapper.map(resource, Worker.class);
    }

    public Worker toModel(UpdateWorkerResource resource)
    {
        return mapper.map(resource, Worker.class);
    }
}