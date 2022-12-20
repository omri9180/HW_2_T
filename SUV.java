import java.io.IOException;
public class SUV extends Wehicle{
    public SUV (WehicleWasher washer) throws IOException {
        super(washer);
        type = "SUV";
    }
}