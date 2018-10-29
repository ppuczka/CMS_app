package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CategoryDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CategoryDao categoryDao;

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

    public List<Category> getAll() {
        Query q1 = entityManager.createQuery("SELECT c FROM Category c");
        List<Category> list = q1.getResultList();
        return list;
    }
}
