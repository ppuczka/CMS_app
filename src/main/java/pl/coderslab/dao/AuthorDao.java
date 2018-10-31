package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AuthorDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Author author) {
        entityManager.persist(author);
    }

    public Author findById(int id) {
        return entityManager.find(Author.class, id);
    }

    public void update(Author author) {
        entityManager.merge(author);
    }

    public void delete(Author author){
        entityManager.remove(entityManager.contains(author) ?
         author : entityManager.merge(author));
    }

    public List<Author> getAll() {
        Query q1 = entityManager.createQuery("SELECT a from Author a");
        List<Author> authhors = q1.getResultList();
        return authhors;
    }
}
