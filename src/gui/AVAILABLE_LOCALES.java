package gui;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public enum AVAILABLE_LOCALES {
    //region enum values
    DE(
        i18nHandler.get("language.de"),
        new Locale.Builder().setLanguage("de").build()
    ),
    EN(
        i18nHandler.get("language.en"),
        new Locale.Builder().setLanguage("en").build()
    );
    //endregion

    //region private variables
    private final String displayName;
    private final Locale locale;
    //endregion

    //region constructors
    AVAILABLE_LOCALES(String displayName, Locale locale) {
        this.displayName = displayName;
        this.locale = locale;
    }
    //endregion

    //region public static methods
    public static boolean isValidName(String name) {
        try {
            AVAILABLE_LOCALES.valueOf(name.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean containsLocale(Locale loc) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getLocale().equals(loc)) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDisplayName(String name) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getDisplayName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public static Optional<AVAILABLE_LOCALES> fromLocale(Locale loc) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getLocale().equals(loc)) {
                return Optional.of(lang);
            }
        }
        return Optional.empty();
    }

    public static Optional<AVAILABLE_LOCALES> fromDisplayName(String name) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getDisplayName().equalsIgnoreCase(name)) {
                return Optional.of(lang);
            }
        }
        return Optional.empty();
    }

    public static List<AVAILABLE_LOCALES> getAll() {
        return Arrays.asList(values());
    }
    //endregion

    //region public methods
    public String getDisplayName() {
        return displayName;
    }

    public Locale getLocale() {
        return locale;
    }
    //endregion
}