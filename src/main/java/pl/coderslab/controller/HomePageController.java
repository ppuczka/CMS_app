package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.List;


@Controller
@RequestMapping(path = "/")
public class HomePageController {

    @Autowired
    ArticleDao articleDao;
    @Autowired
    CategoryDao categoryDao;


    @RequestMapping(path ="/home", method = RequestMethod.GET)
    public String homePage(Model model) {
        List<Article>  articles = articleDao.getAll(5);
        List<Category> categories = categoryDao.getAll();
        model.addAttribute("articles", articles);
        model.addAttribute("categories", categories);
        return "/homePage";
    }


}
