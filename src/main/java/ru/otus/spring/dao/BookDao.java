package ru.otus.spring.dao;

import ru.otus.spring.model.Book;

public interface BookDao {

    void insert(Book book);
    Book getById(long id);
    void updateById(Book book);
    void deleteById(long id);
}
