public abstract class Veicolo {

    private int wheels;
    private int clackson;
    public int getWheels() {
        return wheels;
    }
    public void setWheels(int numeroRoute) {
        wheels = numeroRoute;
    }
    public Veicolo() {

    }
    public void setClackson(int numeroSuono) {
        clackson = numeroSuono;
    }
    public int getClackson() {
        return clackson;
    }
    public void portiera(){
        System.out.println("aperta");
    }

}
