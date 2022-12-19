import java.util.Random;

public abstract class Wehicle extends Thread {
    String type;
    double avgTimeToBeWash;
    Random rnd;

    public Wehicle(String type) {
        this.type = type;
    }

    public abstract void wehicleArraiv();

    public abstract void wehicleEnter_washer();

    public abstract void wehicle_finish();

    public Wehicle chosenWehicle() {
        Random rnd = new Random();
        int n = rnd.nextInt(3) + 1;
        Wehicle w = null;
        switch (n) {
            case 0:
                w = new Truck();
                break;
            case 1:
                w = new SUV();
                break;
            case 2:
                w = new Car();
                break;

            case 3:
                w = new MiniBus();
                break;

        }
        return w;

    }

    @Override
    public void run() {
        try {
            sleep((long) (Math.log(-rnd.nextDouble()) / avgTimeToBeWash));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
