package nosql.injection.demo.model;

import com.mongodb.*;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

public class NoSQLDatabase {

    private DBCollection characters;

    private static NoSQLDatabase instance;

    public static NoSQLDatabase getInstance() throws UnknownHostException {
        if (instance == null) {
            instance = new NoSQLDatabase();
        }
        return instance;
    }

    public InjectionResult insecureFindByName(String name) throws UnknownHostException {

        InjectionResult injectionResult = new InjectionResult();

        String stringQuery = "{ 'name' : '" + name + "'}";
        injectionResult.setStringQuery(stringQuery);

        DBObject databaseQuery = (DBObject) JSON.parse(stringQuery);
        injectionResult.setDatabaseQuery(databaseQuery);

        DBObject result = characters.findOne(databaseQuery);
        injectionResult.setResult(result);

        return injectionResult;
    }


    public InjectionResult secureFindByName(String name) throws UnknownHostException {

        InjectionResult injectionResult = new InjectionResult();

        BasicDBObject databaseQuery = new BasicDBObject("name", name);
        injectionResult.setDatabaseQuery(databaseQuery);

        DBObject result = characters.findOne(databaseQuery);
        injectionResult.setResult(result);

        return injectionResult;
    }



    private NoSQLDatabase() throws UnknownHostException {

        // More details at http://docs.mongodb.org/ecosystem/tutorial/getting-started-with-java-driver/
        MongoClient mongoClient = new MongoClient();

        DB gameOfThronesDatabase = mongoClient.getDB("GameOfThrones");
        gameOfThronesDatabase.dropDatabase();

        characters = gameOfThronesDatabase.getCollection("characters");
        seedData();
    }

    private void seedData() {
        BasicDBObject robb = new BasicDBObject("_id", 1).append("name", "Robb").append("surname", "Stark").append("address", "Kingslayer");
        BasicDBObject sansa = new BasicDBObject("_id", 2).append("name", "Sansa").append("surname", "Stark").append("address", "Kingslayer");
        characters.insert(robb);
        characters.insert(sansa);
    }

}
