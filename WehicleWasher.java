import java.io.File;
import java.util.*;

public class WehicleWasher {
    ArrayList<Wehicle> whashPlace;
    Queue<Wehicle> line;
    ArrayList<Wehicle> inWash;
    Queue<Car> cars;
    Queue<SUV> SUVs;
    Queue<MiniBus> miniBuses;
    Queue<Truck> trucks;
    int needToBeWash;
    double avgBetweenCars;
    double avgTimeToWash;
    Random rnd;

    public WehicleWasher(int places, int needToBeWash, double avgBetweenCars, double timeForWash) {
        this.avgBetweenCars = timeForWash;
        this.needToBeWash = needToBeWash;
        this.avgBetweenCars = avgBetweenCars;
        whashPlace = new ArrayList<Wehicle>();
        line = new LinkedList<Wehicle>();
        inWash = new ArrayList<Wehicle>();
        cars = new LinkedList<Car>();
        SUVs = new LinkedList<SUV>();
        miniBuses = new LinkedList<MiniBus>();
        trucks = new LinkedList<Truck>();


    }

    public void proses() throws InterruptedException {
        int lineCounter = 0;
        while (lineCounter < needToBeWash) {
            Thread.sleep((long) (-Math.log(rnd.nextDouble()) / avgBetweenCars));
            line.add(chosenWehicle());
            lineCounter++;


        }
    }

    public boolean empty_spot(){
        if(whashPlace.isEmpty() && whashPlace.get(needToBeWash-1) !=null){
            return true;
        }else {
            return false;
        }
    }

    public synchronized void q_to_washer(Wehicle w) throws InterruptedException {
        if(empty_spot() == false){
            line.add(w);
            w.wait();
        }else {
            inWash.add(w);
        }

    }

    public Wehicle chosenWehicle() {
        Random rnd = new Random();
        int n = rnd.nextInt(3);
        Wehicle w;
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

            default:
                w = new MiniBus();
                break;

        }
        return w;

    }
}
