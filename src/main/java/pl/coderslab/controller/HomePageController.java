package pl.coderslab.controller;

import com.sun.source.doctree.AuthorTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

@Controller
public class HomePageController {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping("/addAuthor")
    @ResponseBody
    public String addAuthor(@RequestParam String firstName, @RequestParam String lastName,
                            @RequestParam Article article) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        author.
    }
}
