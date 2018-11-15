package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.entity.Article;
import pl.coderslab.validator.DraftValidationGroup;

import java.util.List;

@Controller
@RequestMapping("/draft")
public class DraftController {

    @Autowired
    ArticleDao articleDao;

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
        model.addAttribute("draft",article);
        return "/forms/draftAdd";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@Validated(DraftValidationGroup.class) @ModelAttribute(name = "draft") Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/forms/draftAdd";
        }
        article.setDraft(true);
        articleDao.save(article);
        return "redirect:/article/showAll";
    }

    @RequestMapping(value ="edit/{id}", method = RequestMethod.GET)
    public String edit (Model model, @PathVariable int id) {
        Article article = articleDao.findById(id);
        model.addAttribute("draft", article);
        return "/forms/draftEdit";
    }

    @RequestMapping(value = "/edit/**", method = RequestMethod.POST)
    public String edit(@Validated(DraftValidationGroup.class) @ModelAttribute(name = "draft") Article article, BindingResult result) {
        if (result.hasErrors()) {
            return "/forms/draftEdit";
        }
        article.setDraft(true);
        articleDao.save(article);
        return "redirect:/article/showAll";
    }

}
