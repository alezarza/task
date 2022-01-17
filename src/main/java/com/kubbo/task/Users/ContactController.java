package com.kubbo.task.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "phonebook")
public class ContactController {

    private final ContactService contactService;

    /*To inject the UserServiced declared*/
    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping(path = "get")
    public List<Contact> getContact(){
        return contactService.getContact();
    }

    @PostMapping(path = "register")
    public void registerNewContact(@RequestBody Contact contact){
        contactService.addNewContact(contact);
    }

    @DeleteMapping(path = "delete/{contact_id}")
    public void deleteContact(@PathVariable("contact_id") Long id){
        contactService.deleteContact(id);
    }

   /* @DeleteMapping(path = "deleteByName/{contact_name}")
    public void deleteContactByName(@PathVariable("contact_name") String name){
        contactService.deleteContactByName(name);
    }*/

    @GetMapping(path = "get/{contact_name}")
    public Contact getContactByName(@PathVariable("contact_name") String name){

        return contactService.getContactByName(name);

    }


}
