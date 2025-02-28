public class Car implements Racing {
    private float turbo;
    public boolean esisteTurbo() {
        return false;
    }
    public void setTurbo(int maxTurbo) {
        turbo = maxTurbo;
    }
    public float getTurbo() {
        return turbo;
    }
}
