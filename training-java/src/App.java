import javax.xml.transform.stream.StreamSource;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    int varIstanza; //Variabile di Istanza

    static final double PI_GRECO = 3.14159265358979323846;
    static final String PRIMO_GIORNO_DELLA_SETTIMANA = "lunedì";


    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

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
        System.out.println("il valore di y é:"+y);
        j = 4;
        k= 1.23f;
        System.out.println("il valore di k é:"+k);
        b= true;
        l = 'c'; // per carattere singolo si usano apici singoli

        int numeroIntero = 7; // Dichiarazione ed inizializzazione

        // tipo di dato ----- nome della variabile --- assegnazione di valore ---- valore
            int               numIntero                            =                 4;

        // ciclo for

        for (int i=0; i<10; i++){

        }

        String s;


        for (int i = 1; i <= 5; i++) {
            s = "test";
            System.out.println("i = " + i);
            System.out.println("i = " + i++);
        }
    }
}