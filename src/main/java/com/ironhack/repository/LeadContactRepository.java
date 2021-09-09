package com.ironhack.repository;

import com.ironhack.dao.LeadContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadContactRepository extends JpaRepository<LeadContact, Long> {

    public List<LeadContact> findLeadContactBySalesRep();
}
