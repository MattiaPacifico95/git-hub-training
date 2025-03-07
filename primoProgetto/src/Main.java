//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Car car = new Car("arcobaleno");
        System.out.println("Il primo colore del oggetto e "+car.getColor());

        car.setColor("blackandwhite");
        System.out.println("Oggetto nel nuovo colore: "+car.getColor());
        //System.out.println(car.getColor());

        car.setWheels(4);
        System.out.println(car.getWheels());

        car.portiera();

        //Veicolo veicolo = new Veicolo();



        //car.setClackson(2);

        /*Veicolo veicolo = new Veicolo();
        veicolo.setWheels(4);
        System.out.println(veicolo.getWheels());*/
    }
}