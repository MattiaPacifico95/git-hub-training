package org.mavenexample;

//Tipo Generico, si usa <T>, il contenuto non è ancora stato definito
public class Bottiglia<T> {
    private final T contenuto;

    // Costruttore
    public Bottiglia(T t){
        contenuto = t;
    }
    public T getContenuto(){
        return contenuto;
    }
}
