package com.example.finalfas.worker.api;

import com.example.finalfas.worker.domain.service.RequestService;
import com.example.finalfas.worker.mapping.RequestMapper;
import com.example.finalfas.worker.resource.RequestResource;
import com.example.finalfas.worker.resource.CreateRequestResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Request")
@RestController
@RequestMapping("/api/v1/requests")
@CrossOrigin
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private RequestMapper mapper;

    @GetMapping
    public List<RequestResource> getAllRequest() {
        return mapper.toResource(requestService.getAll());
    }

    @PostMapping("workers/{workerId}")
    public RequestResource createRequest(@PathVariable(name="workerId") Long workerId, @Valid @RequestBody CreateRequestResource request)
    {
        return mapper.toResource(requestService.create(mapper.toModel(request), workerId));
    }

    @DeleteMapping("{requestId}")
    public ResponseEntity<?> deleteRequest(@PathVariable Long requestId)
    {
        return requestService.delete(requestId);
    }

    @GetMapping("worker/{workerId}")
    public List<RequestResource> getRequestByWorker(@PathVariable Long workerId)
    {
        return mapper.toResource(requestService.getByWorkerId(workerId));
    }
}