package edu.java.intermediate.exercise4.services;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

public class GetContactByIdService {

    private ContactRepository repository;

    public GetContactByIdService() {
        this.repository = ContactRepository.getInstance();
    }

    public Contact execute(Integer id){
        Contact contact = null;
        try{
            for (int index = 0; index < this.repository.getContact().size(); index++){
                if(this.repository.getContact().get(index).getId() == id){
                    contact = this.repository.getContact().get(index);
                }
            }
            if(contact == null){
                throw new Exception("Not Exist");
            }
            return contact;
        }catch (Exception e){
            return new Contact();
        }
    }
}
