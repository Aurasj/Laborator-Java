package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PoliticianRepository extends JpaRepository<Politician, Long> {
    Politician findByName(String name);
    void deleteByName(String name);
}
