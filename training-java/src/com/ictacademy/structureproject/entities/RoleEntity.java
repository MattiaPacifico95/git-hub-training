package com.ictacademy.structureproject.entities;

import java.util.Objects;

public class RoleEntity {

    // Role Proprieta
    long idRole;
    String name;

    // Costruttore
    public RoleEntity() {
    }

    // Role Get e Set
    public long getIdRole(long idRole) {
        return this.idRole;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public String getName(String nome) {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Equals e Hashcode
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return idRole == that.idRole && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRole, name);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "idRole=" + idRole +
                ", name='" + name + '\'' +
                '}';
    }
}