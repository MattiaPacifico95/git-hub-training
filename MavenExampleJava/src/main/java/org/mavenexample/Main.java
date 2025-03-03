package org.mavenexample;

//Main
public class Main {
    public static void main(String[] args) {
        //Bottiglia <Tipo generico che viene creato da Vino.java o Acqua.java>
        Bottiglia<Acqua> Levissima = new Bottiglia<Acqua>(new Acqua());
        Bottiglia<Vino> Tavernello = new Bottiglia<Vino>(new Vino());
        Gancio GancioFabbrica = new Gancio();
        for(int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                GancioFabbrica.prendiBottiglia(Levissima);
            } else {
                GancioFabbrica.prendiBottiglia(Tavernello);
            }
        }
    }
}