import java.io.IOException;
public class Car extends Wehicle {
    public Car (WehicleWasher washer) throws IOException {
        super(washer);
        type ="Car";
    }

}