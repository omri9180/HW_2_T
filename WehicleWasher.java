import java.io.File;
import java.util.*;

public class WehicleWasher {
    ArrayList<Wehicle> wash_station;
    ArrayList<Wehicle> line_to_wash;
    ArrayList<Wehicle> wehicles_in_wash;
    ArrayList<Car> cars_after_wash;
    ArrayList<SUV> SUVs_after_wash;
    ArrayList<MiniBus> miniBuses_after_wash;
    ArrayList<Truck> trucks_after_wash;

    WehicleLogger log_w_r;

    int needToBeWash;
    double avgBetweenCars;
    double avgTimeToWash;
    Random rnd;

    public WehicleWasher(int num_of_station, int num_wehicle_to_wash) {
        wash_station = new ArrayList<>(num_of_station);
        this.needToBeWash = num_wehicle_to_wash;
        line_to_wash = new ArrayList<>();
        wehicles_in_wash = new ArrayList<>();

    }


    public void proses() throws InterruptedException {
        int lineCounter = 0;
        while (lineCounter < needToBeWash) {
            Thread.sleep((long) (-Math.log(rnd.nextDouble()) / avgBetweenCars));
            line_to_wash.add(chosenWehicle());
            lineCounter++;


        }
    }

    public boolean empty_spot() {
        if (wash_station.isEmpty() && wash_station.get(needToBeWash - 1) != null) {
            return true;
        } else {
            return false;
        }
    }

    public synchronized void q_to_washer(Wehicle w) throws InterruptedException {
        if (empty_spot() == false) {
            line_to_wash.add(w);
            w.wait();
        } else {
            wehicles_in_wash.add(w);
        }

    }

    public void new_wehicle_toWash() {
        if (empty_spot()) {
            wash_station.add(line_to_wash.get(0));
        }
    }

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
}
