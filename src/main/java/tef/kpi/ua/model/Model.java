package tef.kpi.ua.model;

/**
 * Created by SkarletRED on 01.03.2018.
 */


/**
 * Model is the main class in the program
 * which contains all business logic in
 * the program.
 */
public class Model {
    private Record record;
    private EntityDB database;

    public Model() {
        database = new EntityDB();
        database.createThreeRecords();
    }

    /**
     * This method get temp Record as parameter
     * and white it to record field in this class
     *
     * @param incompleteRecord
     * @throws SuchLoginExistsException
     */
    public void setRecord(Record incompleteRecord) throws SuchLoginExistsException {
        if (database.findLogin(incompleteRecord.getNickname())) {
            throw new SuchLoginExistsException(record);
        }
        this.record = incompleteRecord;
    }

    /**
     * This method is uses only for get
     * reference to revord field
     *
     * @return Record
     */
    public Record getRecord() {
        return record;
    }
}