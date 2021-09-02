package com.ironhack.repository;

import com.ironhack.dao.Contact;
import com.ironhack.dao.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadRepository extends JpaRepository<Lead, Integer> {
}
