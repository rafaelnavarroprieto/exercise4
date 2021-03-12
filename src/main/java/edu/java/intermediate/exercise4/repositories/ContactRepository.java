package edu.java.intermediate.exercise4.repositories;

import edu.java.intermediate.exercise4.models.Contact;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ContactRepository {

    private static ContactRepository repository;
    private List<Contact> contact;

    public static ContactRepository getInstance(){
        if(repository == null){
            repository = new ContactRepository();
            repository.getContact().add(new Contact(1,"Paco","Rodriguez",
                    "paco@correo.com","987654321", new Date(), null));
            repository.getContact().add(new Contact(2,"Miguel","Perez",
                    "Miguel@correo.com","1234565678", new Date(), null));
            repository.getContact().add(new Contact(3,"Luis","Moreno",
                    "Luis@correo.com","9876543456", new Date(), null));
        }
        return repository;
    }

    private ContactRepository() {
        this.contact = new ArrayList<Contact>();
    }

    public List<Contact> getContact() {
        return contact;
    }

    public void setContact(List contact) {
        this.contact = contact;
    }
}
