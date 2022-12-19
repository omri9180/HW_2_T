import java.io.*;

public class WehicleLogger {
    File fileName = new File("log.txt");
    private FileWriter log_Writer;

    private FileReader log_Reader = new FileReader(fileName);
    private BufferedReader read;

    public WehicleLogger() throws FileNotFoundException {
    }

    public synchronized void log_Writer(String log) throws IOException {
        log_Writer = new FileWriter(fileName);
        log_Writer.write(log + "\n");

        log_Writer.close();
    }


    public synchronized void read() throws IOException {
        log_Reader = new FileReader(fileName);
        read = new BufferedReader(log_Reader);
        if (read.ready()) {
            while (read.ready()) {
                System.out.println(read.readLine());
            }
        }
        read.close();
        log_Reader.close();
    }
}
