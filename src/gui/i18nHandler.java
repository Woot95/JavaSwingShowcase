package gui;

import java.util.Locale;
import java.util.ResourceBundle;

public class i18nHandler {
    //Statische Klasse, enthaelt ausschliesslich statische Methoden

    public static void setLocale(Locale locale) {
        Locale.setDefault(locale);
        loadBundle();
    }
    public static void setLocale(AVAILABLE_LOCALES locale) {
        Locale.setDefault(locale.getLocale());
        loadBundle();
    }

    public static String get(String key) {
        return loadBundle().getString(key);
    }

    private static ResourceBundle loadBundle() {
        return ResourceBundle.getBundle("i18n", Locale.getDefault());
    }
}