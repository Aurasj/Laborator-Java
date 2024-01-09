package lab8.src.main.java.com.example.Tema;

import lab8.src.main.java.com.example.Tema.Entity;

import java.util.Collections;
import java.util.List;

@Entity
public class Politician {
    private Long id;
    private String name;
    private String constituency;
    private String party;
    private String note;
    private String legislature;

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

    public static void displayPoliticians(List<Politician> politicians) {
        Collections.sort(politicians);

        for (Politician politician : politicians) {
            System.out.println(politician);
        }
    }
}
