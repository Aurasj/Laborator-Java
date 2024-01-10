package com.example.demo.service;

import com.example.demo.model.Legislator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LegislatorService {
    private List<Legislator> dataset;

    public LegislatorService() {
        this.dataset = readDatasetFromCSV();
    }

    public List<Legislator> getAllLegislators() {
        return dataset;
    }

    public Legislator getLegislatorByName(String name) {
        return dataset.stream()
                .filter(legislator -> legislator.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public void addLegislators(List<Legislator> legislators) {
        dataset.addAll(legislators);
    }

    public void deleteLegislatorByName(String name) {
        dataset.removeIf(legislator -> legislator.getName().equalsIgnoreCase(name));
    }

    public void updateLegislator(String name, String columnName, String columnValue) {
        dataset.stream()
                .filter(legislator -> legislator.getName().equalsIgnoreCase(name))
                .findFirst()
                .ifPresent(legislator -> {
                    switch (columnName.toLowerCase()) {
                        case "constituency":
                            legislator.setConstituency(columnValue);
                            break;
                        case "party":
                            legislator.setParty(columnValue);
                            break;
                        case "note":
                            legislator.setNote(columnValue);
                            break;
                        case "legislature":
                            legislator.setLegislature(columnValue);
                            break;
                        default:
                            // Handle unsupported column
                            break;
                    }
                });
    }

    private List<Legislator> readDatasetFromCSV() {
        List<Legislator> legislators = new ArrayList<>();
        Path path = Paths.get("src/main/resources/dataset.csv");

        try {
            legislators = Files.lines(path)
                    .skip(1) // Skip header
                    .map(line -> {
                        String[] fields = line.split(",");
                        return new Legislator(fields[0], fields[1], fields[2], fields[3], fields[4]);
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return legislators;
    }
}