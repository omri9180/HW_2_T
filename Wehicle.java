import java.util.Random;

public abstract class Wehicle extends Thread{
    String type;
    double avgTimeToBeWash;
    Random rnd;

    public Wehicle(String type) {
        this.type = type;
    }

    @Override
    public void run() {
        try {
            sleep((long) (Math.log(-rnd.nextDouble())/avgTimeToBeWash));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
