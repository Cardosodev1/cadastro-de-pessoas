package projeto.repository;

import projeto.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PersonRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Person person) {
        if (person.getId() == null) {
            em.persist(person);
        } else {
            em.merge(person);
        }
    }

    @Transactional
    public void delete(Person person) {
        Person managed = em.find(Person.class, person.getId());
        if (managed != null) {
            em.remove(managed);
        }
    }

    public Person findById(Long id) {
        return em.find(Person.class, id);
    }

    public List<Person> findByName(String name) {
        return em.createQuery("SELECT p FROM Person p WHERE LOWER(p.name) LIKE LOWER(:name)", Person.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }

}
