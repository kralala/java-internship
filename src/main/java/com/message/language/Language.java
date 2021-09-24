package com.message.language;

import java.util.Locale;

public enum Language {

    RUSSIAN(new Locale("ru","RU")),
    ENGLISH(new Locale("en","US")),
    GERMAN(new Locale("de","DE")),
    FRENCH(new Locale("fr","FR")),
    SWEDISH(new Locale("sv","SE")),
    JAPANESE(new Locale("ja","JP"));

    final Locale locale;

    Language(Locale locale) {
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
