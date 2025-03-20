package com.spring.fidelity.spring_fidelity.utils;

import com.spring.fidelity.spring_fidelity.dtos.RoleDto;
import com.spring.fidelity.spring_fidelity.entities.RoleEntity;

// Conversione da RoleDto a RoleEntity
public class RoleConverter {
    public RoleDto toDto(RoleEntity roleEntity){

        // Espando la classe oggetto RoleDto.
        RoleDto roleDto = new RoleDto();

        // Conversione con set e get
        roleDto.setRoleName(roleEntity.getNome());
        roleDto.setRoleId(roleEntity.getIdRuolo());

        // Alla fine quando è riuscito ritorna la variabile
        return roleDto;
    }

    // Conversione da RoleEntity a RoleDto
    public RoleEntity toEntity(RoleDto roleDto){

        // Espando la classe oggetto RoleEntity
        RoleEntity roleEntity = new RoleEntity();

        // Conversione con set e get
        roleEntity.setNome(roleDto.getRoleName());
        roleEntity.setIdRuolo(roleDto.getRoleId());

        // Alla fine quando è riuscito ritorna la variabile
        return roleEntity;
    }
}
