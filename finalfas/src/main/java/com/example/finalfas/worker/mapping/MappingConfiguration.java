package com.example.finalfas.worker.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("workerMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public WorkerMapper workerMapper() {
        return new WorkerMapper();
    }

    @Bean
    public RequestMapper requestMapper() {
        return new RequestMapper();
    }
}
