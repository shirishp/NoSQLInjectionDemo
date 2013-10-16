package nosql.injection.demo.model;

import com.mongodb.DBObject;

public class InjectionResult {
    private String stringQuery;
    private DBObject databaseQuery;
    private DBObject result;

    public String getStringQuery() {
        return stringQuery;
    }

    public void setStringQuery(String stringQuery) {
        this.stringQuery = stringQuery;
    }

    public DBObject getDatabaseQuery() {
        return databaseQuery;
    }

    public void setDatabaseQuery(DBObject databaseQuery) {
        this.databaseQuery = databaseQuery;
    }

    public DBObject getResult() {
        return result;
    }

    public void setResult(DBObject result) {
        this.result = result;
    }
}
