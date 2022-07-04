package com.example.finalfas.worker.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestResource {
    private Long id;
    private String serviceName;
    private WorkerResource worker;
}