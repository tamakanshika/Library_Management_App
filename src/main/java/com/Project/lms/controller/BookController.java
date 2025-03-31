package com.Project.lms.controller;

import com.Project.lms.model.Book;
import com.Project.lms.repository.BookRepository;
import com.Project.lms.repository.SearchRepository;
import com.Project.lms.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/books")
public class BookController {

    private static final Logger log = LoggerFactory.getLogger(BookController.class);

    @Autowired
    BookRepository repo;

    @Autowired
    private BookService bookService;

    @GetMapping("/home")
    public String homePage(){
        return "index";
    }

    @GetMapping
    public String getAllRecords(@org.jetbrains.annotations.NotNull Model model)
    {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "book_list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "add_book";
    }

    @PostMapping("/save")
    @CrossOrigin
    public String addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        String status = bookService.addBook(book);

        if ("exists".equals(status)) {
            redirectAttributes.addFlashAttribute("error", "A book with this Book ID already exists!");
            return "redirect:/books/add";
        }

        redirectAttributes.addFlashAttribute("success", "Book added successfully!");
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Optional<Book> book = bookService.getBookByBookId(id);
        if (book.isPresent()) {
            model.addAttribute("book", book.get());
            return "edit_book";
        } else {
            return "redirect:/books";
        }
    }

    // Update the book
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable String id, @ModelAttribute("book") Book updatedBook) {
        bookService.updateBook(id, updatedBook);
        return "redirect:/books";
    }

    // Delete a book
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("query") String query, Model model) {
        System.out.println("inside search>>>>>>>>>>>>>>>>>>");
        query = query.trim();
        List<Book> searchResults = bookService.searchBooks(query);
        model.addAttribute("books", searchResults);
        return "book_list";
    }

}
