package edu.java.intermediate.exercise4.resources;

import edu.java.intermediate.exercise4.models.Contact;
import edu.java.intermediate.exercise4.services.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@Path("/contacts")
public class ContactResource {

    private ListContactsService listContactsService;
    private GetContactByIdService getContactByIdService;
    private CreateContactService createContactService;
    private UpdateContactService updateContactService;
    private DeleteContactService deleteContactService;


    public ContactResource() {
        this.listContactsService = new ListContactsService();
        this.getContactByIdService = new GetContactByIdService();
        this.createContactService = new CreateContactService();
        this.updateContactService = new UpdateContactService();
        this.deleteContactService = new DeleteContactService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getAll(){
        return this.listContactsService.execute();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getById(@PathParam("id") int id){
        return getContactByIdService.execute(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact create(Contact contact){
        return createContactService.execute(contact);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact update(@PathParam("id") int id, Contact contact){
        return this.updateContactService.execute(contact, id);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact delete(@PathParam("id") int id){
        return deleteContactService.execute(id);
    }
}
