package tef.kpi.ua.model;

/**
 * Created by SkarletRED on 29.03.2018.
 */

public class SuchLoginExistsException extends Exception{
    private Record wrongData;
    private final String msg = "Such login is already exists!";

    public SuchLoginExistsException(Record wrongData) {
        this.wrongData = wrongData;
    }

    @Override
    public String getMessage() {
        return msg;
    }

    public Record getWrongData() {
        return wrongData;
    }
}
