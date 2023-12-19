import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<Politician> readPoliticiansFromCSV(String filePath) {
        List<Politician> politicians = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0].trim();
                String constituency = data[1].trim();
                String party = data[2].trim();
                String note = data[3].trim();
                String legislature = data[4].trim();

                Politician politician = new Politician(name, constituency, party, note, legislature);
                politicians.add(politician);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return politicians;
    }
}
