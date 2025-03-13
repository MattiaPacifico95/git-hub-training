package com.ictacademy.structureproject.entities;

import java.util.Objects;

public class RoleEntity {


    // Ruolo Proprieta
    long idRuolo;
    String name;

    // Costruttore
    public RoleEntity() {
    }

    // Role Get e Set

    public long getIdRuolo(long idRuolo) {
        return this.idRuolo;
    }

    public void setidRuolo(long idRuolo) {
        this.idRuolo = idRuolo;
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
        return idRuolo == that.idRuolo && Objects.equals(name, that.name);

    }

    @Override
    public int hashCode() {
        return Objects.hash(idRuolo, name);
    }

    @Override
    public String toString() {
        return "RoleEntity{" +
                "idRuolo=" + idRuolo +
                ", name='" + name + '\'' +
                '}';
    }
}
