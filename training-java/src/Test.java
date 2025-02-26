public class Test {

    //firma del metodo
    // 1. modificatore di visibilità
    // 2. tipo di ritorno
    // 3. nome del metodo
    // 4. eventuali parametri in ingresso
    //corpo del metodo

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
}
