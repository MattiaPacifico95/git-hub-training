package lorenzo_esercizi;

// Class Abstract
public abstract class AVehicle {
    public void portieraOpen() {
        System.out.println("Aperta");
    }

    private int Wheels;

    public AVehicle(){
    }
    public void setWheels(int newWheels) {
        Wheels = newWheels;
    }
    public int getWheels() {
        return Wheels;
    }
}
