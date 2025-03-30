package com.Project.lms.service;

import com.Project.lms.model.Book;
import com.Project.lms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


//    public void addBook(Book book) {
//        bookRepository.save(book);
//    }

    public String addBook(Book book) {
        // Check if a book with the same bookId already exists
        if (bookRepository.findByBookId(book.getBookId()).isPresent()) {
            return "exists"; // Return status indicating duplicate bookId
        }

        bookRepository.save(book);
        return "success"; // Return status indicating successful addition
    }

    public Optional<Book> getBookById(String id) {
        return bookRepository.findById(id);
    }

    public Optional<Book> getBookByBookId(String bookId) {
        return bookRepository.findByBookId(bookId);
    }

    public void updateBook(String id, Book updatedBook) {
        Optional<Book> existingBook = bookRepository.findByBookId(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setGenre(updatedBook.getGenre());
            book.setAvailabilityStatus(updatedBook.getAvailabilityStatus());
            bookRepository.save(book);
        }
    }

    public void deleteBook(String id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBooks(String query) {
        return bookRepository.findByBookIdContainingIgnoreCaseOrTitleContainingIgnoreCase(query, query);
    }
}
