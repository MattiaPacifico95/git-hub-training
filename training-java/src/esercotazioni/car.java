package esercotazioni;

public class car implements veicolo, competizione {

    private String color;
    private int nruote;

    public car (String c) {
        setColor(c);
    }

    public void setruote (int numeroRuote) {
        nruote=numeroRuote;
    }


    public int getRuote (){
        return nruote;

    }

    public void setColor (String nuovoColore) {

    color = nuovoColore;

    }

    public String getColor () {

        return color;
    }

    @Override
    public void clacson() {
        System.out.println("Beep");
    }

    public boolean turbo() {
        return true;
    }
}



