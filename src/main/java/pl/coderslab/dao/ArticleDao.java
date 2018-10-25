package pl.coderslab.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.coderslab.entity.Article;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ArticleDao {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    ArticleDao articleDao;


//    public void save(Article article) {
//        entityManager.persist(article);
//    }
//
//    public Article findById(int id) {
//        return entityManager.find(Article.class, id);
//    }
//
//    public void update(Article article) {
//        entityManager.merge(article);
//    }
//
//    public void delete(Article article){
//        entityManager.remove(entityManager.contains(article) ?
//                article : entityManager.merge(article));
//    }


    public List<Article> getAll(int limit) {
       Query q1  = entityManager.createQuery("SELECT a FROM Article a");
       q1.setMaxResults(limit);
       List<Article> list = q1.getResultList();
       return list;

    }
}
