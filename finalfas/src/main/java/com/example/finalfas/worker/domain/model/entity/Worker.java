package com.example.finalfas.worker.domain.model.entity;

import com.example.finalfas.shared.domain.model.AuditModel;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@With
@Entity
@Table(name= "worker")
public class Worker extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String role;

    @NotNull
    @NotBlank
    @Size(max = 40)
    private String specialty;

}
