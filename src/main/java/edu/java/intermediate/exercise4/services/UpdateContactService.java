package edu.java.intermediate.exercise4.services;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

import java.util.Date;

public class UpdateContactService {

    private ContactRepository repository;

    public UpdateContactService() {
        this.repository = ContactRepository.getInstance();
    }

    public Contact execute(final Contact contact, Integer id){
        Contact contactUpdated = null;
        try{
            for(int index = 0; index < this.repository.getContact().size(); index++){
                if(this.repository.getContact().get(index).getId() == id){
                    contactUpdated = this.repository.getContact().get(index);
                    contactUpdated.setFirstName(contact.getFirstName());
                    contactUpdated.setLastName(contact.getLastName());
                    contactUpdated.setEmail(contact.getEmail());
                    contactUpdated.setMobileNumber(contact.getMobileNumber());
                    contactUpdated.setModifiedAt(new Date());
                }
            }
            return contactUpdated;
        }catch (Exception e){
            return new Contact();
        }
    }
}
