package ru.otus.spring.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.spring.model.Book;
import ru.otus.spring.service.BookService;

@ShellComponent
public class ShellMain {

    private final BookService bookService;

    public ShellMain(BookService bookService) {
        this.bookService = bookService;
    }

    @ShellMethod(value = "Create a new book", key = {"c", "create"})
    public void shellCreateBook(long id, long authorId, long genreId, String title) {
        bookService.create(id, authorId, genreId, title);
    }

    @ShellMethod(value = "Get a book by id", key = {"g", "get"})
    public Book shellGetBook(long id) {
        return bookService.getById(id);
    }

    @ShellMethod(value = "Update a book by id", key = {"u", "update"})
    public void shellUpdateBook(long id, long authorId, long genreId, String title) {
        bookService.updateById(id, authorId, genreId, title);
    }

    @ShellMethod(value = "Delete a book by id", key = {"d", "delete"})
    public void shellDeleteBook(long id) {
        bookService.deleteById(id);
    }
}
