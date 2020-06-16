package ru.otus.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.spring.dao.BookDaoJdbc;
import ru.otus.spring.model.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("Service для работы с книгами должен")
@JdbcTest
@Import({BookDaoJdbc.class, BookServiceImpl.class})
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @DisplayName("создавать экземпляр книги")
    @Test
    void shouldCreateBook() {
        Book expectedBook = new Book(6, 1, 1, "title1");
        bookService.create(expectedBook.getId(), expectedBook.getAuthorId(), expectedBook.getAuthorId(), expectedBook.getTitle());
        Book actualBook = bookService.getById(expectedBook.getId());
        assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @DisplayName("обновлять экземпляр книги по id")
    @Test
    void shouldUpdateById() {
        Book expectedBook = new Book(2, 1, 1, "title");
        bookService.updateById(expectedBook.getId(), expectedBook.getAuthorId(), expectedBook.getAuthorId(), expectedBook.getTitle());
        Book actualBook = bookService.getById(expectedBook.getId());
        assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @DisplayName("удалять экземпляр книги по id")
    @Test
    void shouldDeleteById() {
        bookService.deleteById(2);
        Throwable thrown = catchThrowable(() -> {
            bookService.getById(2);
        });
        assertThat(thrown).isInstanceOf(EmptyResultDataAccessException.class);
    }
}