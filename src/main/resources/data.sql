insert into AUTHORS(id, NAME, SURNAME) values (1, 'Лев', 'Толстой');
insert into AUTHORS(ID, NAME, SURNAME) values (2, 'Иван', 'Тургенев');
insert into AUTHORS(ID, NAME, SURNAME) values (3, 'Федор', 'Достоевский');

insert into GENRES(ID, NAME) values (1, 'Роман');
insert into GENRES(ID, NAME) values (2, 'Автобиография');
insert into GENRES(ID, NAME) values (3, 'Философский роман');
insert into GENRES(ID, NAME) values (4, 'Криминал');

insert into BOOKS(ID, AUTHOR_ID, GENRE_ID, TITLE) values (1, 1, 1, 'Война и мир');
insert into BOOKS(ID, AUTHOR_ID, GENRE_ID, TITLE) values (2, 1, 2, 'Автобиография');
insert into BOOKS(ID, AUTHOR_ID, GENRE_ID, TITLE) values (3, 2, 1, 'Отцы и дети');
insert into BOOKS(ID, AUTHOR_ID, GENRE_ID, TITLE) values (4, 3, 3, 'Идиот');
insert into BOOKS(ID, AUTHOR_ID, GENRE_ID, TITLE) values (5, 3, 4, 'Преступление и наказание');