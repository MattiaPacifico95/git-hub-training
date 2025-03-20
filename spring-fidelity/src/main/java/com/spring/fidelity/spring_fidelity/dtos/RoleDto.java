package com.spring.fidelity.spring_fidelity.dtos;

import lombok.Data;

@Data
public class RoleDto {

    // Variabili per il Dto (sono crittografate)
    private Long roleId;
    private String roleName;

    // Costruttore Dto
    public RoleDto() {
    }
}