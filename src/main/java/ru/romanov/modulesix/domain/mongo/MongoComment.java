package ru.romanov.modulesix.domain.mongo;

import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Objects;

public class MongoComment {

    @Field(value = "text")
    private String text;

    public MongoComment() {
    }

    public MongoComment(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "{text=" + text + "}";
    }
}
