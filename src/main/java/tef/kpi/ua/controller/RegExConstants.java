package tef.kpi.ua.controller;

public interface RegExConstants {
    String FLAGS = "(?u)";
    String REGEX_CAPITALIZED_WORD = FLAGS +  "^[A-Z][a-z]{1,20}";
    String REGEX_CAPITALIZED_WORD_WITH_HYPHEN = FLAGS + "^[A-Z]([a-z](-[A-Z])?){1,20}";
    String REGEX_NICKNAME = FLAGS + "^[\\w_-]{6,18}";
    String REGEX_EMAIL = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";
    //String REGEX_URL = "^((https?|ftp)\\:\\/\\/)?([a-z0-9]{1})((\\.[a-z0-9-])|([a-z0-9-]))*\\.([a-z]{2,6})(\\/?)$";
}
