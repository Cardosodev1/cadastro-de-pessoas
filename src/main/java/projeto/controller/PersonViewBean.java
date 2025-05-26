package projeto.controller;

import projeto.model.Person;
import projeto.repository.PersonRepository;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@RequestScoped
public class PersonViewBean implements Serializable {

    private Long personId;
    private Person person;

    @Inject
    private PersonRepository personRepository;

    public void loadPerson() {
        if (personId != null) {
            person = personRepository.findById(personId);
        }
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}