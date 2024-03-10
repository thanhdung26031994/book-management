package com.example.bookmanagement.controller;

import com.example.bookmanagement.model.Book;
import com.example.bookmanagement.model.CodeBook;
import com.example.bookmanagement.model.User;
import com.example.bookmanagement.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping
    public String showList(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);
        return "book";
    }
    @GetMapping("/{id}/detail")
    public String showDetail(@PathVariable Long id,
                             Model model){
        Book book = bookService.findById(id);
        model.addAttribute("book",book);
        return "detail";
    }
    @GetMapping("/{id}/borrow")
    public String borrow(@PathVariable Long id,
                         Model model){
        model.addAttribute("book",bookService.findById(id));
        model.addAttribute("user",new User());
        return "borrow";
    }
    @PostMapping("/{id}/borrow")
    public String borrow(@PathVariable Long id,
                         @ModelAttribute("user") User user,
                         RedirectAttributes redirectAttributes){
        CodeBook codeBook = new CodeBook();
        Book book = bookService.findById(id);
        bookService.saveUser(user);
        codeBook.setBook(book);
        codeBook.setUser(user);
        codeBook.setCode(String.valueOf((int) Math.floor(((Math.random() * 89999) + 10000))));
        bookService.save(codeBook);
        book.setQuantity(book.getQuantity()-1);
        bookService.saveBook(book);
        redirectAttributes.addFlashAttribute("message","Code của bạn là "+codeBook.getCode());
        return "redirect:/book";
    }
    @GetMapping("/{id}/return")
    public String returnBook(){
        return "check";
    }
    @PostMapping("/{id}/return")
    public String returnBook(@RequestParam("code") String code,
                             @PathVariable Long id,
                             @RequestParam("phoneNumber") String phone){
        Book book = bookService.findById(id);
        List<CodeBook> codeBooks = bookService.findAllCodeBook();
        for (CodeBook c: codeBooks){
            if (c.getCode().equals(code) && c.getUser().getPhoneNumber().equals(phone)){
                book.setQuantity(book.getQuantity()+1);
                bookService.saveBook(book);
//                bookService.remove(c);
                return "redirect:/book";
            }
        }
        return "error";
    }
}