package ru.romanov.modulesix.domain.mysql;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "genres")
public class MySqlGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private Set<MySqlBook> booksSet;

    public MySqlGenre() {
    }

    public MySqlGenre(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MySqlBook> getBooksSet() {
        return booksSet;
    }

    public void setBooksSet(Set<MySqlBook> booksSet) {
        this.booksSet = booksSet;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("MySqlGenre{");
        builder.append("id=").append(id);
        builder.append(", name=").append(name);
        if (booksSet != null) {
            builder.append(", booksList={");
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
