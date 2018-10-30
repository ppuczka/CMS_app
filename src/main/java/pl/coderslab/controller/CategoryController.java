package pl.coderslab.controller;

import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Category;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ArticleDao articleDao;

    @RequestMapping("/showAll")
    public String showAll(Model model) {
        List<Category> categoryList = categoryDao.getAll();
        if (categoryList == null) {
          //brak widoku
            return "/nullCatError";
        }
            model.addAttribute("categories", categoryList);
            return "/categories";
    }

    @RequestMapping(value = "/catEdit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable int id, Model model) {
        Category category = categoryDao.findById(id);
        model.addAttribute("category", category);
        return "forms/categoryEdit";

    }

    @ModelAttribute("articles")
    public Collection<Article> populateArticles() {
        return this.articleDao.getAll();

    }

    @RequestMapping(value = "/catEdit/**", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Category category) {
        categoryDao.update(category);
        return "redirect:/category/showAll";
    }

    @RequestMapping(value = "/catDelConfirm/{id}", method = RequestMethod.GET)
    public String deleteConf(@PathVariable int id, Model model) {
        model.addAttribute("id", id);
        return "/deleteConfirmation";
    }

    @RequestMapping(value = "/catDel/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        Category toDelete = categoryDao.findById(id);
        categoryDao.delete(toDelete);
        return "redirect:/category/showAll";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addForm(Model model){
        model.addAttribute("category", new Category());
        return "/forms/categoryAdd";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Category category) {
        categoryDao.save(category);
        return "redirect:/category/showAll";
    }

    }
