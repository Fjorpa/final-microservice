package com.example.finalfas.worker.mapping;

import com.example.finalfas.shared.mapping.EnhancedModelMapper;
import com.example.finalfas.worker.domain.model.entity.Request;
import com.example.finalfas.worker.resource.RequestResource;
import com.example.finalfas.worker.resource.CreateRequestResource;
import com.example.finalfas.worker.resource.UpdateRequestResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RequestMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public RequestResource toResource(Request model)
    {
        return mapper.map(model, RequestResource.class);
    }

    public List<RequestResource> toResource(List<Request> model)
    {
        return mapper.mapList(model, RequestResource.class);
    }

    public Request toModel(CreateRequestResource resource)
    {
        return mapper.map(resource, Request.class);
    }

    public Request toModel(UpdateRequestResource resource)
    {
        return mapper.map(resource, Request.class);
    }
}