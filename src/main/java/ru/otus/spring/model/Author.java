package ru.otus.spring.model;

public class Author {

    private final long id;
    private final String surname;
    private final String name;

    public Author(long id, String surname, String name) {
        this.id = id;
        this.surname = surname;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }
}
