package tef.kpi.ua.model;

import tef.kpi.ua.view.View;

/**
 * Created by SkarletRED on 01.03.2018.
 */

public class Record {
    private String subscriberName;
    private String nickname;
    private String email;

    public Record(){}

    public Record(Record inputRecord) {
        this(inputRecord.subscriberName, inputRecord.nickname, inputRecord.email);
    }

    public Record(String subscriberName, String nickname, String email) {
        this.subscriberName = subscriberName;
        this.nickname = nickname;
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return subscriberName;
    }

    public String getEmail() {
        return email;
    }

    /**
     * This method set subscriber name
     * @param subscriberName
     */
    public void setName(String subscriberName) {
        this.subscriberName = subscriberName;
    }

    /**
     * This method set nickname
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * This method set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method generate string which
     * consist information about record
     * @return full information about record
     */
    @Override
    public String toString() {
        String specialSymbol = View.NEXT_LINE_SING;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(View.getLocaleMassage(View.RECORD)).append(specialSymbol)
                .append(View.getLocaleMassage(View.INPUT_SUBSCRIBER_NAME))
                .append(subscriberName).append(specialSymbol)
                .append(View.getSubstringForOutput(View.getLocaleMassage(View.INPUT_NICKNAME)))
                .append(nickname).append(specialSymbol)
                .append(email);
        return stringBuffer.toString();
    }
}