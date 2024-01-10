package com.example.demo.model;

public class Legislator {
    private String name;
    private String constituency;
    private String party;
    private String note;
    private String legislature;

    public Legislator() {
    }

    public Legislator(String name, String constituency, String party, String note, String legislature) {
        this.name = name;
        this.constituency = constituency;
        this.party = party;
        this.note = note;
        this.legislature = legislature;
    }

    public String getName() {
        return name;
    }

    public String getConstituency() {
        return constituency;
    }

    public String getParty() {
        return party;
    }

    public String getNote() {
        return note;
    }

    public String getLegislature() {
        return legislature;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConstituency(String constituency) {
        this.constituency = constituency;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setLegislature(String legislature) {
        this.legislature = legislature;
    }
}