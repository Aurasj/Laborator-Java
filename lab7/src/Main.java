import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String filePath = "lab7/src/members_of_chamber_of_deputies_romania.csv";

        // Runnable
        CsvReaderRunnable csvReaderRunnable = new CsvReaderRunnable(filePath);
        Thread runnableThread = new Thread(csvReaderRunnable);
        runnableThread.start();
        runnableThread.join();
        List<Politician> politiciansRunnable = csvReaderRunnable.getPoliticians();
        Politician.displayPoliticians(politiciansRunnable);

        // Thread
        CsvReaderThread csvReaderThread = new CsvReaderThread(filePath);
        csvReaderThread.start();
        csvReaderThread.join();
        List<Politician> politiciansThread = csvReaderThread.getPoliticians();
        Politician.displayPoliticians(politiciansThread);
    }
}
