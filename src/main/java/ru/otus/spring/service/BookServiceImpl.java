package ru.otus.spring.service;

import org.springframework.stereotype.Service;
import ru.otus.spring.dao.BookDao;
import ru.otus.spring.model.Book;

import javax.validation.constraints.NotNull;

@Service
public class BookServiceImpl implements BookService {

    private final BookDao bookDao;

    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void create(@NotNull long id, @NotNull long authorId, @NotNull long genreId, @NotNull String title) {
        Book book = new Book(id, authorId, genreId, title);
        bookDao.insert(book);
    }

    @Override
    public Book getById(@NotNull long id) {
        return bookDao.getById(id);
    }

    @Override
    public void updateById(long id, long authorId, long genreId, String title) {
        Book book = new Book(id, authorId, genreId, title);
        bookDao.updateById(book);
    }

    @Override
    public void deleteById(@NotNull long id) {
        bookDao.deleteById(id);
    }
}
