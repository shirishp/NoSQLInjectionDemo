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

        DBCursor result = characters.find(databaseQuery);
        injectionResult.setResult(result);

        return injectionResult;
    }


    public InjectionResult secureFindByName(String name) throws UnknownHostException {

        InjectionResult injectionResult = new InjectionResult();

        BasicDBObject databaseQuery = new BasicDBObject("name", name);
        injectionResult.setDatabaseQuery(databaseQuery);

        DBCursor result = characters.find(databaseQuery);
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
        BasicDBObject tyrion = new BasicDBObject("_id", 3).append("name", "Tyrion").append("surname", "Lannister").append("address", "Casterly Rock");
        BasicDBObject jaime = new BasicDBObject("_id", 4).append("name", "Jaime").append("surname", "Lannister").append("address", "Casterly Rock");
        BasicDBObject cersei = new BasicDBObject("_id", 5).append("name", "Cersei").append("surname", "Lannister").append("address", "Casterly Rock");
        BasicDBObject tywin = new BasicDBObject("_id", 6).append("name", "Tywin").append("surname", "Lannister").append("address", "Casterly Rock");
        characters.insert(robb);
        characters.insert(sansa);
        characters.insert(tyrion);
        characters.insert(jaime);
        characters.insert(cersei);
        characters.insert(tywin);
    }

}
