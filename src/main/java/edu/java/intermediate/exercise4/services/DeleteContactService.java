package edu.java.intermediate.exercise4.services;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

import java.util.Date;

public class DeleteContactService {
    private ContactRepository repository;

    public DeleteContactService() {
        this.repository = ContactRepository.getInstance();
    }

    public Contact execute(Integer id){
        Contact contactRemoved = null;
        try{
            for (int index = 0; index < this.repository.getContact().size(); index++){
                if(this.repository.getContact().get(index).getId() == id){
                    contactRemoved = this.repository.getContact().get(index);
                    this.repository.getContact().remove(index);
                }
            }
            return contactRemoved;
        }catch (Exception e){
            return new Contact();
        }
    }
}
