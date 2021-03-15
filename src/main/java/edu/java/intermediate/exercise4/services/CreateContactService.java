package edu.java.intermediate.exercise4.services;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

import java.util.Date;

public class CreateContactService {

    private ContactRepository repository;

    public CreateContactService() {
        this.repository = ContactRepository.getInstance();
    }

    public Contact execute(final Contact contact){
        int id = 0;
        for(int index = 0; index < this.repository.getContact().size(); index++){
            if(this.repository.getContact().get(index).getId() > id){
                id = this.repository.getContact().get(index).getId();
            }
        }
        contact.setId(id+1);
        contact.setCreatedAt(new Date());
        this.repository.getContact().add(contact);
        return contact;
    }
}
