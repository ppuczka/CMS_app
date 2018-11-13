package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Category;

import javax.validation.Valid;
import java.util.Collection;
import java.util.List;

@RequestMapping("/article")
@Controller
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private AuthorDao authorDao;


    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Article> articles = articleDao.getAll();
        model.addAttribute("articles", articles);
        return "/articles";
    }

    @RequestMapping(value = "/delConfirm/{id}", method = RequestMethod.GET)
    public String delConfirm(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        return "/articleDeleteConfirmation";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String del(@PathVariable int id) {
        Article article = articleDao.findById(id);
        articleDao.delete(article);
        return "redirect:/article/showAll";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model) {
        Article article = new Article();
        model.addAttribute("article",article);
        return "/forms/articleAdd";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/forms/articleAdd";
        }
        articleDao.save(article);
        return "redirect:/article/showAll";
    }

    @RequestMapping(value ="edit/{id}", method = RequestMethod.GET)
    public String edit (Model model, @PathVariable int id) {
        Article article = articleDao.findById(id);
        model.addAttribute("article", article);
        return "/forms/articleEdit";
    }

    @RequestMapping(value = "/edit/**", method = RequestMethod.POST)
    public String edit(@Valid @ModelAttribute Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/forms/articleEdit";
        }
        articleDao.save(article);
        return "redirect:/article/showAll";
    }


    @ModelAttribute("categories")
    public Collection<Category> populateCategories() {
        return this.categoryDao.getAll();

    }

    @ModelAttribute("authors")
    public Collection<Author> populatedAuthors() {
        return this.authorDao.getAll();

    }



}
