package gui;

import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

public class i18nHandler {
    private static ResourceBundle bundle = loadBundle();


    public static void setLocale(Locale locale) {
        Locale.setDefault(locale);
        bundle = loadBundle();
    }
    public static void setLocale(AVAILABLE_LOCALES locale) {
        Locale.setDefault(locale.getLocale());
        bundle = loadBundle();
    }

    public static String get(String key) {
        return bundle.getString(key);
    }

    private static ResourceBundle loadBundle() {
        return ResourceBundle.getBundle("i18n", Locale.getDefault());
    }
}