package com.ironhack.repository;

import com.ironhack.dao.Account;
import com.ironhack.dao.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Optional<Contact> findByEmail(String email);
}
