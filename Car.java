import java.io.IOException;
import java.util.concurrent.Semaphore;

public class Car extends Wehicle {
    //car class exntends vehicle and in its constructor updates its type
    public Car (WehicleWasher washer) throws IOException {
        super(washer);
        type ="Car";
    }

}