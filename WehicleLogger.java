import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WehicleLogger {

    File file = new File("log.txt");

    Wehicle wehicle;


    public void WriteToFileLog(){
        String log = this.wehicle.type +" ID: " + wehicle.threadId() + "\n";
        try {
            PrintWriter wr = new PrintWriter(file);
            wr.write(log);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }

}
