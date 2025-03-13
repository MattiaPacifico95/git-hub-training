//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main{
    public static void main(String[] args) {
        Veicolo v = new Veicolo();
        boolean esisteTurbo=!v.esisteTurbo();
        if(esisteTurbo){
            v.setTurbo(10);
        }

    }
}