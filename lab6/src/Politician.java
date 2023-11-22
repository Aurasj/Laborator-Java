import java.util.Collections;
import java.util.List;


public class Politician implements Comparable<Politician> {
    private final String name;
    private final String constituency;
    private final String party;
    private final String note;
    private final String legislature;

    public Politician(String name, String constituency, String party, String note, String legislature) {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
        this.note = note;
        this.legislature = legislature;
    }
    @Override
    public int compareTo(Politician other) {
        return this.legislature.compareTo(other.legislature);
    }

    @Override
    public String toString() {
        return "Politician{" +
                "name='" + name + '\'' +
                ", constituency='" + constituency + '\'' +
                ", party='" + party + '\'' +
                ", note='" + note + '\'' +
                ", legislature='" + legislature + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String filePath = "lab6/src/members_of_chamber_of_deputies_romania.csv";
        List<Politician> politicians = CsvReader.readPoliticiansFromCSV(filePath);

        Collections.sort(politicians);

        for (Politician politician : politicians) {
            System.out.println(politician);
        }
    }
}
