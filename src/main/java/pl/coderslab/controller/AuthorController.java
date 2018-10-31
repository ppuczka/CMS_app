package pl.coderslab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.ArticleDao;
import pl.coderslab.dao.AuthorDao;
import pl.coderslab.dao.CategoryDao;
import pl.coderslab.entity.Article;
import pl.coderslab.entity.Author;

import java.util.List;
@RequestMapping("/author")
@Controller
public class AuthorController {

    @Autowired
    private AuthorDao authorDao;


    @RequestMapping(value = "/showAll", method = RequestMethod.GET)
    public String showAll(Model model) {
        List<Author> authors = authorDao.getAll();
        model.addAttribute("authors", authors);
        return "/authors";
    }

    @RequestMapping(value = "/delConfirm/{id}", method = RequestMethod.GET)
    public String delConfirm(Model model, @PathVariable int id) {
        model.addAttribute("id", id);
        return "/authorDeleteConfirmation";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String del(@PathVariable int id) {
        Author author = authorDao.findById(id);
        authorDao.delete(author);
        return "redirect:/author/showAll";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Model model) {
        Author author = new Author();
        model.addAttribute("author",author);
        return "/forms/authorAdd";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Author author) {
        authorDao.save(author);
        return "redirect:/author/showAll";
    }

    @RequestMapping(value ="edit/{id}", method = RequestMethod.GET)
    public String edit(Model model, @PathVariable int id) {
        Author author = authorDao.findById(id);
        model.addAttribute("author", author);
        return "/forms/authorEdit";
    }

    @RequestMapping(value = "/edit/**", method = RequestMethod.POST)
    public String edit(@ModelAttribute Author author) {
        authorDao.update(author);
        return "redirect:/author/showAll";
    }



}
