public class Car {

    public Car(String primoColore) {
        setColore(primoColore);
    }

    private String colore;

    public void setColore(String nuovoColore) {

        colore = nuovoColore;
    }

    public String getColore() {
        return colore;
    }
}
