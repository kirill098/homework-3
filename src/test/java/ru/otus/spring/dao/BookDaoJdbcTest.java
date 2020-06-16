package ru.otus.spring.dao;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.dao.EmptyResultDataAccessException;
import ru.otus.spring.model.Book;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@DisplayName("Dao для работы с книгами должно")
@JdbcTest
@Import(BookDaoJdbc.class)
class BookDaoJdbcTest {

    @Autowired
    private BookDaoJdbc dao;

    @DisplayName("создавать экземпляр книги")
    @Test
    void shouldInsertBook() {
        Book expectedBook = new Book(6, 1, 1, "title");
        dao.insert(expectedBook);
        Book actualBook = dao.getById(6);
        Assertions.assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @DisplayName("обновлять экземпляр книги по id")
    @Test
    void shouldUpdateById() {
        Book expectedBook = new Book(2, 1, 1, "title");
        dao.updateById(expectedBook);
        Book actualBook = dao.getById(expectedBook.getId());
        Assertions.assertThat(actualBook).isEqualToComparingFieldByField(expectedBook);
    }

    @DisplayName("удалять экземпляр книги по id")
    @Test
    void shouldDeleteById() {
        dao.deleteById(2);
        Throwable thrown = catchThrowable(() -> {
           dao.getById(2);
        });
        assertThat(thrown).isInstanceOf(EmptyResultDataAccessException.class);
    }
}