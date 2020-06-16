package ru.otus.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.stereotype.Repository;
import ru.otus.spring.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

@SuppressWarnings({"SqlNoDataSourceInspection", "ConstantConditions", "SqlDialectInspection"})
@Repository
public class BookDaoJdbc implements BookDao {

    private final NamedParameterJdbcOperations jdbc;

    public BookDaoJdbc(NamedParameterJdbcOperations jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public void insert(Book book) {
        final Map<String, Object> params = Map.of(
                "id", book.getId(),
                "authorId", book.getAuthorId(),
                "genreId", book.getGenreId(),
                "title", book.getTitle());
        jdbc.update("insert into BOOKS(id, author_id, genre_id, title)" +
                "values (:id, :authorId, :genreId, :title)", params);
    }

    @Override
    public Book getById(long id) {
        final Map<String, Object> params = Map.of("id", id);
        return jdbc.queryForObject("select * from books where id = :id", params, new BookMapper());
    }

    @Override
    public void updateById(Book book) {
        final Map<String, Object> params = Map.of(
                "id", book.getId(),
                "authorId", book.getAuthorId(),
                "genreId", book.getGenreId(),
                "title", book.getTitle());
        jdbc.update("update books set id = :id, author_id = :authorId, genre_id = :genreId, " +
                "title = :title where id = :id", params);
    }

    @Override
    public void deleteById(long id) {
        final Map<String, Object> params = Map.of("id", id);
        jdbc.update("delete from books where id = :id", params);
    }

    private static class BookMapper implements RowMapper<Book> {
        @Override
        public Book mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            long authorId = resultSet.getLong("author_id");
            long genreId = resultSet.getLong("genre_id");
            String title = resultSet.getString("title");
            return new Book(id, authorId, genreId, title);
        }
    }
}
