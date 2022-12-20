import java.io.IOException;

public class MiniBus extends Wehicle{
    public MiniBus (WehicleWasher washer) throws IOException {
        super(washer);
        type = "MiniBus";
    }
}