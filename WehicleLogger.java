import java.io.*;

public class WehicleLogger {


    public WehicleLogger() throws IOException {
    }


    public synchronized void log_Writer(String log) throws IOException {
        FileWriter fw = new FileWriter("log.txt", true);
        BufferedWriter log_w = new BufferedWriter(fw);
        log_w.write( log);
        log_w.newLine();

        log_w.close();
        fw.close();
    }


    public synchronized void read() throws IOException {
        FileReader fr = new FileReader("log.txt");
        if (fr.ready()) {
            BufferedReader log_r = new BufferedReader(fr);
            String log_rd = log_r.readLine();
            while (log_rd != null) {
                System.out.println(log_rd);
                log_rd = log_r.readLine();
            }
            log_r.close();
        } else {
            throw new FileNotFoundException();
        }

        fr.close();
    }
}
