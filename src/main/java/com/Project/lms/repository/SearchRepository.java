package com.Project.lms.repository;

import com.Project.lms.model.Book;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SearchRepository {

    List<Book>searchByTitle(String title);

    List<Book>searchByID(String ID);

    List<Book>findbyText(String text);
}

