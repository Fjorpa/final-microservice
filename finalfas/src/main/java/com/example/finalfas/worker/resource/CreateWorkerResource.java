package com.example.finalfas.worker.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateWorkerResource {
    @NotNull
    @NotBlank
    @Size(max = 40)
    private String role;
    @NotNull
    @NotBlank
    @Size(max = 40)
    private String specialty;
}