package ru.romanov.modulesix.domain.mysql;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "authors")
public class MySqlAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fio;

    @ManyToMany(mappedBy = "authorsSet", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<MySqlBook> booksSet;

    public MySqlAuthor() {
    }

    public MySqlAuthor(String fio) {
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Set<MySqlBook> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<MySqlBook> booksSet) {
        this.booksSet = booksSet;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MySqlAuthor{");
        builder.append("id=").append(id);
        builder.append(", fio=").append(fio);
        if (booksSet != null) {
            builder.append(", booksSet={");
            if (!booksSet.isEmpty()) {
                int i = 0;
                for(MySqlBook book : booksSet) {
                    i++;
                    builder.append(book.getName());
                    if (i != booksSet.size()) {
                        builder.append(", ");
                    }
                }
            } else {
                builder.append("Нет книг");
            }
            builder.append("}");
        }
        return builder.toString();
    }
}
