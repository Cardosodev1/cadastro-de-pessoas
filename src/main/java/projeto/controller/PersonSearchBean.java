package projeto.controller;

import projeto.model.Person;
import projeto.repository.PersonRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class PersonSearchBean implements Serializable {

    private Person person = new Person();
    private List<Person> persons;

    @Inject
    private PersonRepository personRepository;

    public void search() {
        persons = personRepository.findByName(person.getName());
    }

    public void clear() {
        person = new Person();
        persons = null;
    }

    public void delete(Person p) {
        personRepository.delete(p);
        search();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
