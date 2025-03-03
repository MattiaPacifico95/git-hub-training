package org.mavenexample;

public class Gancio {
    void prendiBottiglia(Bottiglia<?> bottiglia){
        // get è su Bottiglia.java e dipende dal tipo generico
        System.out.println("Ho presso: " + bottiglia.getContenuto());
    }
}
