package ru.rodionov.servlets.server.locale;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleRunner {
    public static void main(String[] args) {
        Locale locale = new Locale("en", "US");
        System.out.println(Locale.getDefault());
        ResourceBundle translations = ResourceBundle.getBundle("translations");
        System.out.println(translations.getString("page.login.password"));
    }
}
