import java.io.IOException;
public class Truck extends Wehicle{
    public Truck (WehicleWasher washer) throws IOException {
        super(washer);
        type = "Truck";
    }
}