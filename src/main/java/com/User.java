package com;

import com.message.language.Language;

public class User {

    private final Long id;
    private final String name;
    private final Language language;

    public User(Long id, String name, Language language) {
        this.id = id;
        this.name = name;
        this.language = language;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Language getLanguage() {
        return language;
    }
}
