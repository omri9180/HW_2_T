import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class WehicleWasher {

    int num_station = 0;
    ArrayList<Wehicle> wehicles_inWash;//in wash list
    ArrayList<Wehicle> wehicles;//
    int num_of_wehicle;
    ArrayList<Wehicle> cars_after_wash = new ArrayList<>();
    ArrayList<Wehicle> suv_after_wash = new ArrayList<>();
    ArrayList<Wehicle> truck_after_wash = new ArrayList<>();
    ArrayList<Wehicle> minibus_after_wash = new ArrayList<>();
    WehicleLogger log;
    int num_wash_st;


    public WehicleWasher() throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number of washing stations");
        this.num_wash_st = in.nextInt();
        this.wehicles_inWash = new ArrayList<>(num_wash_st);
        System.out.println("How many vehicles will be washed today?");
        this.num_of_wehicle = in.nextInt();
        this.wehicles = new ArrayList<>();


    }

    public synchronized void in_wash(Wehicle v) {
        //get a vehicle and inserts it into the inwash list, also searches for it in the main cars list and remove it from there, will update count of both lists
        for (int i = 0; i < wehicles.size(); i++) {
            if (wehicles.get(i).equals(v)) {
                wehicles.remove(i);
            }
        }
        wehicles_inWash.add(v);
        num_station++;


    }

    public synchronized void finished_wash(Wehicle w) {
        for (int i = 0; i < num_station; i++) {
            if (wehicles_inWash.get(i).equals(w)) {
                wehicles_inWash.remove(i);
                num_station--;
            }
        }
        switch (w.getType()) {
            case ("Car"): {
                cars_after_wash.add(w);
                break;
            }

            case ("SUV"): {
                suv_after_wash.add(w);
                break;
            }

            case ("Truck"): {
                truck_after_wash.add(w);
                break;
            }

            case ("MiniBus"): {
                minibus_after_wash.add(w);
                break;
            }

        }
    }

}
