package ru.romanov.modulesix.domain.mongo;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

public class MongoAuthor {

    @Field(value = "fio")
    private String fio;

    public MongoAuthor() {
    }

    public MongoAuthor(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    @Override
    public String toString() {
        return "{fio=" + fio + "}";
    }
}
