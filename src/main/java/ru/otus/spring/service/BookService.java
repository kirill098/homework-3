package ru.otus.spring.service;

import ru.otus.spring.model.Book;

public interface BookService {

    void create(long id, long authorId, long genreId, String title);
    Book getById(long id);
    void updateById(long id, long authorId, long genreId, String title);
    void deleteById(long id);
}
