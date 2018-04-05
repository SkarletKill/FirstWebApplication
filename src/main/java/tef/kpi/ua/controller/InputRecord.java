package tef.kpi.ua.controller;

import tef.kpi.ua.model.Record;
import tef.kpi.ua.view.View;

import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 * Created by SkarletRED on 05.04.2018.
 */

public class InputRecord {
    private Record inputRecord;
    private ArrayList<String> errorKeys;
    private boolean correct;

    public InputRecord() {
        errorKeys = new ArrayList<>();
        inputRecord = new Record();
    }

    public void processInput() {
        getErrorKeys();
        checkInput();
    }

    private void checkInput() {
        correct =  checkStringValueWithRegexp(inputRecord.getName(), RegExConstants.REGEX_CAPITALIZED_WORD_WITH_HYPHEN)
                && checkStringValueWithRegexp(inputRecord.getNickname(), RegExConstants.REGEX_NICKNAME)
                && checkStringValueWithRegexp(inputRecord.getEmail(), RegExConstants.REGEX_EMAIL);
    }

    private void checkErrorMessage(String field, String regexp, String errKey) {
        if (!checkStringValueWithRegexp(field, regexp)) {
            addErrorKey(errKey);
        }
    }

    private void getErrorKeys() {
        checkErrorMessage(inputRecord.getName(), RegExConstants.REGEX_CAPITALIZED_WORD_WITH_HYPHEN, View.WRONG_INPUT_DATA);
        checkErrorMessage(inputRecord.getEmail(), RegExConstants.REGEX_NICKNAME, View.WRONG_INPUT_DATA);
        checkErrorMessage(inputRecord.getNickname(), RegExConstants.REGEX_EMAIL, View.WRONG_INPUT_DATA);
    }

    private void addErrorKey(String errKey) {
        errorKeys.add(errKey);
    }

    public boolean isCorrect() {
        return correct;
    }

    public String getErrorMessage() {
        return View.concatenationStringsWithBundle(errorKeys);
    }

    public Record getInputRecord() {
        return new Record(inputRecord);
    }

    public void setInputNoteData(String name, String email, String login) {
        inputRecord.setName(name);
        inputRecord.setEmail(email);
        inputRecord.setNickname(login);

        errorKeys = new ArrayList<>();
    }

    private boolean checkStringValueWithRegexp(String string, String regexp) {
        return Pattern.compile(regexp).matcher(string).matches();
    }
}
