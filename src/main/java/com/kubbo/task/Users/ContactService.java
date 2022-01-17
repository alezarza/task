package com.kubbo.task.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getContact(){

        return contactRepository.findAll();
    }

    public void addNewContact(Contact contact) {

        Optional<Contact> contactOptional = contactRepository.findContactByName(contact.getName());
        if(contactOptional.isPresent()){
            throw new IllegalStateException("This contact is already in the phonebook");
        }
        contactRepository.save(contact);
    }

    public void deleteContact(Long contactId) {
        if(!contactRepository.existsById(contactId)){
            throw new IllegalStateException("This contact ID doesn't exists in the phonebook");
        }
        contactRepository.deleteById(contactId);
    }

   /* public void deleteContactByName(String name) {
        Optional<Contact> contactOptional = contactRepository.findContactByName(name);
        if(!contactOptional.isPresent()){
            throw new IllegalStateException("This contact ID doesn't exists in the phonebook");
        }
        contactRepository.deleteContactByName(name);
    }*/

    public Contact getContactByName(String name) {
        Optional<Contact> contactOptional = contactRepository.findContactByName(name);
        if(!contactOptional.isPresent()){
            throw new IllegalStateException("This contact doesn't exists in the phonebook");
        }

        return contactOptional.get();

    }
}
