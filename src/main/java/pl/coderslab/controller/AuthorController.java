package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import java.util.List;

public class AuthorController {

//    @Autowired
//    private AuthorDao authorDao;
//
//    @Autowired
//    private ArticleDao articleDao;
//
//    @Autowired
//    private CategoryDao categoryDao;
//
//
//    @RequestMapping("/addAuthor")
//    @ResponseBody
//    public String addAuthor(@RequestParam String firstName, @RequestParam String lastName,
//                            @RequestParam List<Integer> articleIds) {
//        Author author = new Author();
//        author.setFirstName(firstName);
//        author.setLastName(lastName);
//        if (articleIds != null) {
//            for(int id : articleIds) {
//                Article article = articleDao.findById(id);
//                author.getArticles().add(article);
//            }
//        }
//        authorDao.save(author);
//        return "Zapis do bazy udany " + author.toString();
//
//    }
}
