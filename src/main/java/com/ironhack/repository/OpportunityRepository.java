package com.ironhack.repository;

import com.ironhack.converter.*;
import com.ironhack.dao.Opportunity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long>{

    @Query("SELECT new com.ironhack.converter.OpportunityCountBySalesRep(c.salesRep, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c GROUP BY c.salesRep")
    List<OpportunityCountBySalesRep> countBySalesRep();

    @Query("SELECT new com.ironhack.converter.OpportunityCountBySalesRep(c.salesRep, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_won' GROUP BY c.salesRep")
    List<OpportunityCountBySalesRep> countCloseWonBySalesRep();

    @Query("SELECT new com.ironhack.converter.OpportunityCountBySalesRep(c.salesRep, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_lost' GROUP BY c.salesRep")
    List<OpportunityCountBySalesRep> countCloseLostBySalesRep();

    @Query("SELECT new com.ironhack.converter.OpportunityCountBySalesRep(c.salesRep, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'open' GROUP BY c.salesRep")
    List<OpportunityCountBySalesRep> countOpenBySalesRep();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByProduct(c.productType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c GROUP BY c.productType")
    List<OpportunityCountByProduct> countByProduct();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByProduct(c.productType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_won' GROUP BY c.productType")
    List<OpportunityCountByProduct> countClosedWonByProduct();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByProduct(c.productType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_lost' GROUP BY c.productType")
    List<OpportunityCountByProduct> countClosedLostByProduct();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByProduct(c.productType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'open' GROUP BY c.productType")
    List<OpportunityCountByProduct> countOpenByProduct();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCountry(c.accountId.country, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c GROUP BY c.accountId.country")
    List<OpportunityCountByCountry> countByCountry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCountry(c.accountId.country, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_won' GROUP BY c.accountId.country")
    List<OpportunityCountByCountry> countClosedWonByCountry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCountry(c.accountId.country, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_lost' GROUP BY c.accountId.country")
    List<OpportunityCountByCountry> countClosedLostByCountry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCountry(c.accountId.country, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'open' GROUP BY c.accountId.country")
    List<OpportunityCountByCountry> countOpenByCountry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCity(c.accountId.city, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c GROUP BY c.accountId.city")
    List<OpportunityCountByCity> countByCity();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCity(c.accountId.city, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_won' GROUP BY c.accountId.city")
    List<OpportunityCountByCity> countClosedWonByCity();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCity(c.accountId.city, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_lost' GROUP BY c.accountId.city")
    List<OpportunityCountByCity> countClosedLostByCity();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByCity(c.accountId.city, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'open' GROUP BY c.accountId.city")
    List<OpportunityCountByCity> countOpenByCity();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByIndustry(c.accountId.industryType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c GROUP BY c.accountId.industryType")
    List<OpportunityCountByIndustry> countByIndustry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByIndustry(c.accountId.industryType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_won' GROUP BY c.accountId.industryType")
    List<OpportunityCountByIndustry> countClosedWonByIndustry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByIndustry(c.accountId.industryType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'closed_lost' GROUP BY c.accountId.industryType")
    List<OpportunityCountByIndustry> countClosedLostByIndustry();

    @Query("SELECT new com.ironhack.converter.OpportunityCountByIndustry(c.accountId.industryType, COUNT(c.opportunityId)) " +
            " FROM Opportunity AS c WHERE c.status = 'open' GROUP BY c.accountId.industryType")
    List<OpportunityCountByIndustry> countOpenByIndustry();

//    @Query("SELECT AVG(c.account.employeeCount), COUNT(c.opportunityId)" +
//            " FROM Opportunity AS c")
//    List<Long> mean();

}
