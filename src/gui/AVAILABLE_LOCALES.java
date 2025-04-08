package gui;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

public enum AVAILABLE_LOCALES {
    DE(i18nHandler.get("language.de"), new Locale.Builder().setLanguage("de").build()), EN(i18nHandler.get("language.en"), new Locale.Builder().setLanguage("en").build());

    private final String displayName;
    private final Locale locale;

    AVAILABLE_LOCALES(String displayName, Locale locale) {
        this.displayName = displayName;
        this.locale = locale;
    }

    public String getDisplayName() {
        return displayName;
    }

    public Locale getLocale() {
        return locale;
    }

    // ✅ 1. Prüfen, ob ein Enum-Name gültig ist (z. B. "DE")
    public static boolean isValidName(String name) {
        try {
            AVAILABLE_LOCALES.valueOf(name.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    // ✅ 2. Prüfen, ob ein Locale enthalten ist
    public static boolean containsLocale(Locale loc) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getLocale().equals(loc)) {
                return true;
            }
        }
        return false;
    }

    // ✅ 3. Prüfen, ob ein DisplayName enthalten ist
    public static boolean containsDisplayName(String name) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getDisplayName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // ✅ 4. Enum-Wert anhand Locale finden
    public static Optional<AVAILABLE_LOCALES> fromLocale(Locale loc) {
        for (AVAILABLE_LOCALES lang : values()) {
            if (lang.getLocale().equals(loc)) {
                return Optional.of(lang);
            }
        }
        return Optional.empty();
    }

    // ✅ 5. Enum-Wert anhand DisplayName finden
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
}