package com.Project.lms.repository;

import com.Project.lms.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book,String>{

    @Query("{ '$or': [ { 'bookId': ?0 }, { 'title': { $regex: ?0, $options: 'i' } } ] }")
    List<Book> findByBookIdContainingIgnoreCaseOrTitleContainingIgnoreCase(String bookId, String title);

    Optional<Book> findByBookId(String bookId);
}
