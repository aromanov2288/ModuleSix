package ru.romanov.modulesix.domain.mysql;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class MySqlComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String text;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private MySqlBook book;

    public MySqlComment() {
    }

    public MySqlComment(String text, MySqlBook book) {
        this.text = text;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MySqlBook getBook() {
        return book;
    }

    public void setBook(MySqlBook book) {
        this.book = book;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MySqlComment{");
        builder.append("id=").append(id);
        builder.append(", text=").append(text);
        builder.append(", book=").append(book.getName());
        builder.append("}");
        return builder.toString();
    }
}
