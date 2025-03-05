package Entities;

import esercotazioni.Esercizi;
import interfaces.CommonInterface;

import java.sql.Timestamp;
import java.util.Objects;

public class UserEntity extends BaseEntity implements CommonInterface {

    String nome;
    String cognome;
    String email;
    String descrizione;
    Timestamp dataNascita;

    // costruttore di default
    public UserEntity(){}

    // costruttore custom
    public UserEntity(String nome, String email){
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Timestamp getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Timestamp dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(nome, that.nome) && Objects.equals(cognome, that.cognome) && Objects.equals(email, that.email) && Objects.equals(descrizione, that.descrizione) && Objects.equals(dataNascita, that.dataNascita);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, cognome, email, descrizione, dataNascita);
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", dataNascita=" + dataNascita +
                '}';
    }

    @Override
    public int somma(int a, int b) {
        int somma = a + b;
        return somma;
    }

}
