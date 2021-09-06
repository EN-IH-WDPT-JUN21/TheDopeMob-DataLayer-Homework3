package com.ironhack.repository;

import com.ironhack.dao.SalesRep;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public interface SalesRepRepository extends JpaRepository<SalesRep, Long> {


}
