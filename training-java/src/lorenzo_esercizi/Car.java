package lorenzo_esercizi;

public class Car implements Vehicle, Racing {
    private String color;
    private int Wheels;

    public boolean turbo() {
        return true;
    }

    public Car(String c){
        setColor(c);
    }
    public void setColor(String newColor) {
        color = newColor;
    }
public String getColor() {
        return color;
    }
    public void setWheels(int newWheels){
        Wheels = newWheels;
    };

    public int getWheels(){
        return Wheels;
    };

    public void portieraOpen(){
    }
}