package com.ironhack.repository;

import com.ironhack.dao.Lead;
import com.ironhack.dao.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Integer>{
}
