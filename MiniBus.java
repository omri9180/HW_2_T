import java.io.IOException;
import java.util.concurrent.Semaphore;

public class MiniBus extends Wehicle{
    //MiniBus class exntends vehicle and in its constructor updates its type 
    public MiniBus (WehicleWasher washer) throws IOException {
        super(washer);
        type = "MiniBus";
    }
}