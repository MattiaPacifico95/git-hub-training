package esercotazioni;

public class Test {

    // Firma del metodo
    // 1. modificatore di visibilità
    // 2. tipo di ritorno
    // 3. nome del metodo
    // 4. eventuali parametri in ingresso
    // corpo del metodo


    // Ogni volta che creiamo una classe bisogna creare un costruttore

    public Test() {
    }

    public int sottrazione(int x, int y) {
        int risultato = x-y;
        return risultato;
    }

    public boolean verificaStringa(String s) {

        String confronto = "ciao";
        if (s.equals(confronto)){  // verica che s sia dello stesso tipo di confronto, verifica che entrambe siano stringhe
            System.out.println("le stringhe sono uguali");
            return true;
        } else {
            System.out.println("le stringhe non sono uguali");
            return false;
        }

    }

    public boolean sommaPari(int x, float y) {

        if(y != Math.floor(y)) {
            /* SE IL DECIMALE CHE VADO AD APPROSSIMARE E' DIVERSO
                DAL CORRISPONDENTE INTERO SENZA LA VIRGOLA, DI SICURO
                LA SOMMA NON SARà MAI PARI
             */
            return false;
        }

        float somma = x+y;

        if(somma%2 == 0) {
            return true;
        } else {
            return false;
        }

    }
}
