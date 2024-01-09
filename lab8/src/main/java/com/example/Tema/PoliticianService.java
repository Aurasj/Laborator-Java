package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/politicians")
public class PoliticianService {

    @Autowired
    private PoliticianRepository politicianRepository;

    @GetMapping("/get/{columnName}/{value}")
    public ResponseEntity<Politician> getPoliticianByColumn(@PathVariable String columnName, @PathVariable String value) {
        Politician politician = null;
        switch (columnName.toLowerCase()) {
            case "name":
                politician = politicianRepository.findByName(value);
                break;
        }

        if (politician != null) {
            return ResponseEntity.ok(politician);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addPoliticians(@RequestBody List<Politician> politicians) {
        politicianRepository.saveAll(politicians);
        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/delete/{columnName}/{value}")
    public ResponseEntity<Void> deletePolitician(@PathVariable String columnName, @PathVariable String value) {
        switch (columnName.toLowerCase()) {
            case "name":
                politicianRepository.deleteByName(value);
                break;
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}/{columnName}/{value}")
    public ResponseEntity<Void> updatePolitician(@PathVariable Long id, @PathVariable String columnName, @PathVariable String value) {
        Politician politician = politicianRepository.findById(id).orElse(null);
        if (politician != null) {
            switch (columnName.toLowerCase()) {
                case "name":
                    politician.setName(value);
                    break;
            }

            politicianRepository.save(politician);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
