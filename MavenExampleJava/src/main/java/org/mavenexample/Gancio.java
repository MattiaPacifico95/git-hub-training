package org.mavenexample;

public class Gancio {
    void prendiBottiglia(Bottiglia<?> bottiglia){
        System.out.println("Ho presso: " + bottiglia.getContenuto());
    }
}
