package ru.otus.spring.model;

public class Book {

    private long id;
    private final long authorId;
    private final long genreId;
    private final String title;

    public Book(long id, long authorId, long genreId, String title) {
        this.id = id;
        this.authorId = authorId;
        this.genreId = genreId;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getGenreId() {
        return genreId;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", authorId=" + authorId +
                ", genreId=" + genreId +
                ", title='" + title + '\'' +
                '}';
    }
}
