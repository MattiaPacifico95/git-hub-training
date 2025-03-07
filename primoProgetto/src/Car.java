public class Car extends Veicolo {
    private String color;
    private int countWheels;

    public String getColor() {
        return color;
    }
    public void setColor(String colore) {
        color = colore;
    }
    public Car(String c) {
        setColor(c);
    }

    @Override
    public void portiera() {
        System.out.println("chiusa");
    }


}
