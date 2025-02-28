public class Car extends Vehicle {

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

    @Override
    public void clacson() {
        System.out.println("Beep beep");
    }
}
