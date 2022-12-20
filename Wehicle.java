import java.io.IOException;
import java.util.Random;

public abstract class Wehicle implements Runnable {
    double washing_time;
    double waitTime;
    WehicleWasher washer;

    String type;
    WehicleLogger log = new WehicleLogger();
    Random rnd = new Random();

    public Wehicle( WehicleWasher washer) throws IOException {
        //constructor for vehicle getting wash time and wait time, semaphore and washer
        this.washer = washer;

        this.waitTime =rnd.nextDouble(2)+1;
        this.washing_time = rnd.nextDouble(3)+1;
    }


    public void run() {
        //will wait the amount of time it needs until "arriving to wash" then will aqquire a permit from the semaphore when one is available
        //will sleep with the aquired permit the given time for it to get washed and then realease it
        //while running will call the washer's list update funcs

        try {
            Thread.sleep((long) waitTime * 1000);
            System.out.println(this.type + " " + Thread.currentThread().getName() + " Arrived to queue");
            log.log_Writer(this.type + " " + Thread.currentThread().getName() + " Threead ID: " + Thread.currentThread().getId() + " Arrived to queue");
            System.out.println(this.type + " " + Thread.currentThread().getName() + " Entered Washing Station");
            log.log_Writer(this.type + " " + Thread.currentThread().getName() + " Threead ID: " + Thread.currentThread().getId() + " Entered Washing Station");
            washer.in_wash(this);
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
