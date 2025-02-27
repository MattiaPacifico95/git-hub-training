package lorenzo_esercizi;

public class Esercizio0 {

    // Firma del metodo
    // 1. modificatore di visibilità (public)
    // 2. tipo di ritorno (int)
    // 3. nome del metodo (sottrazione)
    // 4. eventuali parametri in ingresso (int x, int y)
    // corpo del metodo

    public int sottrazione(int x, int y) {
        int risultato = x-y;
        return risultato;
    }

    // creato il metodo booleano che si chiama "verificaStringa" con ingresso e la variabile "s" booleana
    public boolean verificaStringa(String s) {

        // creo una variabile stringa con nome confronto e lo inizializzo con "ciao"
        String confronto = "ciao";

        // if (Traduzione = se), prendo la variabile che avevo in ingresso che era una stringa e creo il metodo equals, lo metto in confronto con variabile "confronto"
        if (s.equals(confronto)){  // verica che "s" sia dello stesso tipo di confronto, verifica che entrambe siano stringhe
            System.out.println("le stringhe sono uguali");
            // Se le due stringe sono ugualli allora è vero e stampa print
            return true;
        // else (Traduzione: altrimenti) stampa print se è su False
        } else {
            System.out.println("le stringhe non sono uguali");
            return false;
        }
    }
}