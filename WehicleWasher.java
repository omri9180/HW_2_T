import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class WehicleWasher {
    Scanner input = new Scanner(System.in);
    int num_of_wehicle;
    int num_wash_st;
    ArrayList<Wehicle> wehicles_inWash;
    ArrayList<Wehicle> wehicles_q;

    ArrayList<Wehicle> wehicles;
    ArrayList<Wehicle> cars_after_wash = new ArrayList<>();
    ArrayList<Wehicle> suv_after_wash = new ArrayList<>();
    ArrayList<Wehicle> truck_after_wash = new ArrayList<>();
    ArrayList<Wehicle> minibus_after_wash = new ArrayList<>();
    WehicleLogger log;

    public WehicleWasher() throws FileNotFoundException {

        System.out.println("Enter number of washing stations");
        this.num_wash_st = input.nextInt();
        this.wehicles_inWash = new ArrayList<>(num_wash_st);
        System.out.println("How many vehicles to washe?");
        this.num_of_wehicle = input.nextInt();
        this.wehicles_q = new ArrayList<>();
        this.wehicles = new ArrayList<>(num_of_wehicle);


    }

    public synchronized void in_wash(Wehicle v) {
            wehicles_inWash.add(v);
        }
    public synchronized void finished_wash(Wehicle w) {
        for (int i = 0; i < wehicles_inWash.size(); i++) {
            if (wehicles_inWash.get(i).equals(w)) {
                wehicles_inWash.remove(i);
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