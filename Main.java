import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Random rand = new Random();
        long Tstart = System.currentTimeMillis();
        WehicleWasher weh = new WehicleWasher();
        WehicleLogger logger = new WehicleLogger();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < weh.num_of_wehicle; i++) {
            switch (rand.nextInt(4)) {
                case (0):
                    weh.wehicles.add(new Car(weh));
                    break;
                case (1):
                    weh.wehicles.add(new SUV(weh));
                    break;
                case (2):
                    weh.wehicles.add(new Truck(weh));
                    break;
                case (3):
                    weh.wehicles.add(new MiniBus(weh));
                    break;
            }
            long Tend = System.currentTimeMillis();

            threads.add(i, new Thread(weh.wehicles.get(i), "Vehicle " + i));
            Thread.sleep(800);
            threads.get(i).start();
            logger.log_Writer("Thread ID: " + threads.get(i).threadId()+" time from the start: " + (Tend - Tstart) +" Mils");

        }

    }
}