public interface Vehicle {

    /* METODI E PROPRIETA' CLASSE
    private int nRuote;

    public Vehicle() {    }


    public void setNRuote(int numero) {

        nRuote = numero;
    }

    public int getNRuote() {

        return nRuote;
    }

    public void clacson() {
        System.out.println("Suono clacson generico");
    }
    */

    // METODI INTERFACCIA
    void setNRuote(int numero);

    int getNRuote();

    void clacson();
}
