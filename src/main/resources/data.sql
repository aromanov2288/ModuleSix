DELETE FROM COMMENTS;
DELETE FROM BOOKS_AUTHORS;
DELETE FROM BOOKS;
DELETE FROM GENRES;
DELETE FROM AUTHORS;

INSERT INTO AUTHORS (FIO) VALUES ('Pushkin');
INSERT INTO AUTHORS (FIO) VALUES ('Lermontov');
INSERT INTO AUTHORS (FIO) VALUES ('Gogol');

INSERT INTO GENRES (NAME) VALUES ('Povest');
INSERT INTO GENRES (NAME) VALUES ('Skazka');

INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book1Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book2Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book3Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book4Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book5Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book6Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book7Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book8Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book9Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book10Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book11Name', 1);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book12Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book13Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book14Name', 2);
INSERT INTO BOOKS (NAME, GENRE_ID) VALUES ('Book15Name', 1);

INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (1, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (1, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (2, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (3, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (3, 3);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (4, 3);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (5, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (5, 3);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (6, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (7, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (7, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (7, 3);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (8, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (9, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (10, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (11, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (12, 3);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (13, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (14, 2);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (15, 1);
INSERT INTO BOOKS_AUTHORS (BOOK_ID, AUTHOR_ID) VALUES (15, 1);

INSERT INTO COMMENTS (TEXT, BOOK_ID) VALUES ('Super', 1);
INSERT INTO COMMENTS (TEXT, BOOK_ID) VALUES ('Kruto', 2);
INSERT INTO COMMENTS (TEXT, BOOK_ID) VALUES ('Nravitsa', 2);
INSERT INTO COMMENTS (TEXT, BOOK_ID) VALUES ('Otpad', 3);

