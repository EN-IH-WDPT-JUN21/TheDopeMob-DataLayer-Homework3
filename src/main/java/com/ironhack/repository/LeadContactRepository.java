package com.ironhack.repository;

import com.ironhack.converter.LeadCountBySalesRep;
import com.ironhack.dao.LeadContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeadContactRepository extends JpaRepository<LeadContact, Long> {

    @Query("SELECT new com.ironhack.converter.LeadCountBySalesRep(c.salesRep, COUNT(c.leadId)) " +
            " FROM LeadContact AS c GROUP BY c.salesRep")
    List<LeadCountBySalesRep> countBySalesRep();
}
