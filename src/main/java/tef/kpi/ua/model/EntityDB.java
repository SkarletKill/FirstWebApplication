package tef.kpi.ua.model;

import java.util.ArrayList;

/**
 * Created by SkarletRED on 29.03.2018.
 */

public class EntityDB {
    private ArrayList<Record> records;

    public EntityDB() {
        records = new ArrayList<>();
    }

    public EntityDB(Record record) {
        records.add(record);
    }

    private Record generateRecord(String template) {
        Record temp = new Record();
        temp.setName(template);
        temp.setNickname(template);
        temp.setEmail(template + "@example.com");

        return temp;
    }

    public void createThreeRecords(){
        Record rec1 = generateRecord("default");
        rec1.setNickname("JavaDev");
        records.add(rec1);

        Record rec2 = generateRecord("default");
        rec2.setNickname("JavaEE");
        records.add(rec2);

        Record rec3 = generateRecord("default");
        rec3.setNickname("JavaJunior");
        records.add(rec3);
    }

    public boolean findLogin(String login){
        for (Record e :
                records) {
            if (login.equals(e.getNickname())) return true;
        }
        return false;
    }

}
