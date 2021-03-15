package edu.java.intermediate.exercise4.services;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

import java.util.List;

public class ListContactsService {

    private ContactRepository repository;

    public ListContactsService() {
        this.repository = ContactRepository.getInstance();
    }

    public List<Contact> execute(){
        return this.repository.getContact();
    }
}
