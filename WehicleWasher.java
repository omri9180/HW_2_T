import java.util.*;

public class WehicleWasher {
    Set<Wehicle> whashPlace;
    Queue<Wehicle> line;
    Set<Wehicle> inWash;
    Queue<Car> cars;
    Queue<SUV> SUVs;
    Queue<MiniBus> miniBuses;
    Queue<Truck> trucks;
    int needToBeWash;
    double avgBetweenCars;
    double avgTimeToWash;
    Random rnd;

    public WehicleWasher(int places, int needToBeWash, double avgBetweenCars, double timeForWash){
        whashPlace = new HashSet<Wehicle>();
        line = new LinkedList<Wehicle>();
        inWash = new HashSet<Wehicle>();
        cars = new LinkedList<Car>();
        SUVs = new LinkedList<SUV>();
        miniBuses = new LinkedList<MiniBus>();
        trucks = new LinkedList<Truck>();
        this.avgBetweenCars = timeForWash;
        this.needToBeWash = needToBeWash;
        this.avgBetweenCars = avgBetweenCars;



    }

    public void proses() throws InterruptedException {
        int lineCounter = 0;
        while(lineCounter < needToBeWash){
           Thread.sleep((long) (-Math.log(rnd.nextDouble())/avgBetweenCars));
           line.add(chosenWehicle());
           lineCounter++;


        }
    }

    public Wehicle chosenWehicle(){
        Random rnd = new Random();
        int n = rnd.nextInt(3);
        Wehicle w;
        switch (n){
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
