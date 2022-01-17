package com.kubbo.task.Users;

import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository <Contact, Long> {

    //@Query("SELECT c FROM Contact c WHERE c.email = ?1")
    //Optional<Contact> findContactByEmail(String email);

    @Query("SELECT c FROM Contact c WHERE c.name = ?1")
    Optional<Contact> findContactByName(String name);

    /*Deleted because is only possible to delete with int (is possible with contact id)
    @Transactional
    @Modifying
    @Query("DELETE FROM Contact c WHERE c.name = ?1")
    Optional<Contact> deleteContactByName(String name);*/

}
