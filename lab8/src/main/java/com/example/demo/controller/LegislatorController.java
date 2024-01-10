package com.example.demo.controller;

import com.example.demo.model.Legislator;
import com.example.demo.service.LegislatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/legislators")
public class LegislatorController {
    private final LegislatorService legislatorService;

    public LegislatorController(LegislatorService legislatorService) {
        this.legislatorService = legislatorService;
    }

    @GetMapping
    public List<Legislator> getAllLegislators() {
        return legislatorService.getAllLegislators();
    }

    @GetMapping("/{name}")
    public Legislator getLegislatorByName(@PathVariable String name) {
        return legislatorService.getLegislatorByName(name);
    }

    @PostMapping
    public void addLegislators(@RequestBody List<Legislator> legislators) {
        legislatorService.addLegislators(legislators);
    }

    @DeleteMapping("/{name}")
    public void deleteLegislatorByName(@PathVariable String name) {
        legislatorService.deleteLegislatorByName(name);
    }

    @PutMapping("/{name}")
    public void updateLegislator(@PathVariable String name,
                                 @RequestParam String columnName,
                                 @RequestParam String columnValue) {
        legislatorService.updateLegislator(name, columnName, columnValue);
    }
}