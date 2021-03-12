package edu.java.intermediate.exercise4.resources;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.repositories.ContactRepository;

import javax.net.ssl.StandardConstants;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/contacts")
public class ContactResource {

    private ContactRepository repository;

    public ContactResource() {
        this.repository = ContactRepository.getInstance();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll(){
        return this.repository.getContact();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getById(@PathParam("id") int id){
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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact create(Contact contact){
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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact update(@PathParam("id") int id, Contact contact){
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

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact delete(@PathParam("id") int id){
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
