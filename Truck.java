import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Truck extends Wehicle{
    public Truck (WehicleWasher washer) throws IOException {
        super(washer);
        type = "Truck";
    }
}