package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class CategoryDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Category category) {
        entityManager.persist(category);
    }

    public Category findById(int id) {
        return entityManager.find(Category.class, id);
    }

    public void update(Category category) {
        entityManager.merge(category);
    }

    public void delete(Category category){
        entityManager.remove(entityManager.contains(category) ?
                category : entityManager.merge(category));
    }
}
