package projeto.controller;

import projeto.model.Address;
import projeto.model.Contact;
import projeto.model.Document;
import projeto.model.Person;
import projeto.repository.PersonRepository;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
public class PersonRegisterBean implements Serializable {

    private Person person = new Person();
    private Integer personId;

    private Document document = new Document();
    private Address address = new Address();
    private Contact contact = new Contact();

    @Inject
    private PersonRepository personRepository;

    @PostConstruct
    public void init() {
        document = new Document();
        address = new Address();
        contact = new Contact();

        if (personId != null) {
            person = personRepository.findById(personId);
            if (person == null) {
                person = new Person();
            }
        } else {
            person = new Person();
        }
    }

    public void addDocument() {
        document.setPerson(person);
        person.getDocuments().add(document);
        document = new Document();
    }

    public void removeDocument(Document doc) {
        person.getDocuments().remove(doc);
    }

    public void addAddress() {
        address.setPerson(person);
        person.getAddresses().add(address);
        address = new Address();
    }

    public void removeAddress(Address addr) {
        person.getAddresses().remove(addr);
    }

    public void addContact() {
        contact.setPerson(person);
        person.getContacts().add(contact);
        contact = new Contact();
    }

    public void removeContact(Contact cont) {
        person.getContacts().remove(cont);
    }

    public void save() {
        personRepository.save(person);
        person = new Person();
        document = new Document();
        address = new Address();
        contact = new Contact();
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }
}
