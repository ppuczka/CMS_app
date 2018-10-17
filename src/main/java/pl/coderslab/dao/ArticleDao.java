package pl.coderslab.dao;

import org.springframework.stereotype.Component;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;


    public void save(Article article) {
        entityManager.persist(article);
    }

    public Article findById(int id) {
        return entityManager.find(Article.class, id);
    }

    public void update(Article article) {
        entityManager.merge(article);
    }

    public void delete(Article article){
        entityManager.remove(entityManager.contains(article) ?
                article : entityManager.merge(article));
    }
}
