package tef.kpi.ua.view;

import java.util.Locale;
import java.util.ResourceBundle;

public interface RecordStringConstants {

    // Resource Bundle Installation's
    String MESSAGES_BUNDLE_NAME = "messages";
    ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua"));    // Ukrainian
                    new Locale("en"));    // English

    Integer localeCorrection = (bundle.getLocale().toString().equals("en"))? 6: 8;

    // Text's constants
    String INPUT_STRING_DATA = "input.string.data";
    String WRONG_INPUT_DATA = "wrong.input.data";
    String CORRECT_INPUT_DATA = "correct.input.data";

    String RECORD = "output.record";

    String INPUT_SUBSCRIBER_NAME = "input.subscriber.name";
    String INPUT_NICKNAME = "input.nickname";
    String INPUT_NICKNAME_EXIST = "input.nickname.exist";
    String INPUT_EMAIL = "input.email";
}