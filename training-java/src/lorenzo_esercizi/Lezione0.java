package lorenzo_esercizi;

// Modificatori di accesso Java. In Java, i modificatori di accesso public, private, e protected determinare la visibilità e l'accessibilità di classi, metodi e variabili.
// Il public il modificatore consente di accedere a un membro da qualsiasi luogo, anche al di fuori del pacchetto e dalle classi figlio in altri pacchetti.
// Il private il modificatore limita l'accesso solo all'interno della classe in cui è dichiarato, rendendolo inaccessibile dall'esterno della classe, anche alle classi di bambini.
// Il protected il modificatore consente l'accesso all'interno dello stesso pacchetto e anche alle classi figlio in altri pacchetti. Tuttavia, è possibile accedere a un membro protetto da una classe figlio solo se la classe figlio viene istanziata all'interno dello stesso pacchetto della classe padre.
public class Lezione0 {

    int varIstanza; //Variabile di Istanza

    // Final:
    // Il valore che viene assegnato non può più cambiare
    static final double PI_GRECO = 3.14159265358979323846;
    static final String PRIMO_GIORNO_DELLA_SETTIMANA = "lunedì";


    // Static:
    // crea una cella di memoria che sarà sempre assegnata alla variabile o costante fino a quando esiste l’applicazione.
    public static void main(String[] args) {

        //richiamo metodo calcola somma con input
        int risultato = calcolaSommaDaInput(3,6);
        System.out.printf("Risultato: %d\n", risultato);

        // DICHIARAZIONE TIPI DI DATO PRIMITIVI

        int x; // numeri interi 32 bit
        double y; // virgola fissa 32 bit
        long j; // numeri interi 64 bit
        float k; // numeri con virgola mobile
        char l; // un singolo carattere
        boolean b; // espressione booleana quindi true o false

        // INIZZIALIZZAZIONE

        x = -3;
        y = 1.23;
        System.out.println("il valore di y é:" + y);
        j = 4;
        k = 1.23f;
        System.out.println("il valore di k é:" + k);
        b = true;
        l = 'c';

        int numeroIntero = 7; // Dichiarazione ed inizializzazione

        // tipo di dato ----- nome della variabile --- assegnazione di valore ---- valore
        int numIntero = 4;

        // ciclo for

        for (int i = 0; i < 10; i++) {

        }

        // IF ELSE (Traduzione: SE ALTRO)

        int firstNumber = 3;
        int secondNumber = 2;
        int thirdNumber = 7;

        switch (thirdNumber) {
            case 1:
                System.out.println("----->" + 1);
                break;
            case 2:
                System.out.println("----->" + 2);
                break;
            case 3:
                System.out.println("----->" + 3);
                break;
            default:
                System.out.println("nessuno dei precedenti");
        }

        // Meglio if che switch
         if (firstNumber == secondNumber) {
            System.out.println("first number equals second number");
        } else if (firstNumber > secondNumber) {
            System.out.println("maggiore del secondo");
        } else if (secondNumber % 2 == 0) {
            System.out.println("condizione è vera");
        } else {
            System.out.println("not equals");
        }

        if (firstNumber == secondNumber) {
            System.out.println("first number equals second number");
        }

        if (firstNumber > secondNumber) {
            System.out.println("maggiore del secondo");
        }

        if (secondNumber % 2 == 0) {
            System.out.println("condizione è vera");
        }

        String s = "casa";
        String n = "ciao";

        int num = 3;


        // s == n si traduce con "s è una stringa come n?"
        // s.queals(n) si traduce con "è vero che s e n hanno lo stesso valore?"

        // Ciclo While
        while (s.equals(n)) {
            System.out.println(true);
        }


        for (int i = 1; i <= 5; i++) {
            s = "test";
            System.out.println("i = " + i);
            System.out.println("i = " + i++);
        }


    }

    // modificatore di visibilità - tipo di ritorno - nome del metodo
    public int calcolaSomma() {  //senza parametri in ingresso
        int primoAddendo = 2;
        int secondoAddendo = 1;

        int somma = primoAddendo + secondoAddendo;

        return somma;
    }

    int parSin = 3;
    int parDes = 4;

    // Metodo con parametri in ingresso
    public static int calcolaSommaDaInput(int x, int y) {  //senza parametri in ingresso

        int somma = x + y;

        return somma;
    }
}