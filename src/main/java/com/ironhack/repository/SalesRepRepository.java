package com.ironhack.repository;

import com.ironhack.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {
    public Optional<SalesRep> findByName(String name);

}
