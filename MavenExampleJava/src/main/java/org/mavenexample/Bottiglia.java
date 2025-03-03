package org.mavenexample;

public class Bottiglia<T> {
    private T contenuto;

    // Costruttore
    public Bottiglia(T t){
        contenuto = t;
    }
    public T getContenuto(){
        return contenuto;
    }
}
