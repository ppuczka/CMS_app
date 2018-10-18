package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;

import java.util.List;


@Controller
@RequestMapping(path = "/home")
public class HomePageController {

    @Autowired
    ArticleDao articleDao;

    public List<Article> getAllArticles() {
        List<Article> articles = articleDao.getAll();
            for (Article a : articles) {
                System.out.println(a.toString());
            }
        return articles;
    }
}
