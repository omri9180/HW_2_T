import java.io.IOException;
import java.util.Random;
public abstract class Wehicle implements Runnable {
    double washing_time;
    double waitTime;
    WehicleWasher washer;
    String type;
    WehicleLogger log = new WehicleLogger();
    Random rnd = new Random();
   public Wehicle(WehicleWasher washer) throws IOException {
        this.washer = washer;
        this.waitTime = rnd.nextInt(2) + 1;
        this.washing_time = rnd.nextInt(3) + 1;

    }
    public void run() {
        try {
                washer.wehicles_q.add(washer.wehicles.get(0));
                System.out.println(this.type + " " + Thread.currentThread().getName() + " Arrived to queue");
                log.log_Writer(this.type + " " + Thread.currentThread().getName() + " Threead ID: " + Thread.currentThread().getId() + " Arrived to queue");
                Thread.sleep((long) waitTime * 1000);
                System.out.println(this.type + " " + Thread.currentThread().getName() + " Entered Washing Station");
                log.log_Writer(this.type + " " + Thread.currentThread().getName() + " Threead ID: " + Thread.currentThread().getId() + " Entered Washing Station");
                washer.in_wash(washer.wehicles_q.get(0));
                washer.finished_wash(this);
                Thread.sleep((long) washing_time * 1000);
                washer.finished_wash(this);
                System.out.println(this.type + " " + Thread.currentThread().getName() + " Finished Washing");
                log.log_Writer(this.type + " " + Thread.currentThread().getName() + " Threead ID: " + Thread.currentThread().getId() + " Finished Washing");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String getType() {
        return this.type;
    }

}