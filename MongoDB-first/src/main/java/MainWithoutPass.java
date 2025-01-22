
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;


import java.util.ArrayList;
import java.util.List;


public class MainWithoutPass {
    public static void main(String[] args) {

        // 1. Creating a Mongo client
        MongoClient mongoClient = new MongoClient( "localhost" , 27017 );


        // 2. Creating Credentials
        mongoClient.startSession();

        // 3. Accessing the database
        MongoDatabase database = mongoClient.getDatabase("myDb");

        // 4. Creating a collection
        // database.createCollection("sampleCollection");
        // System.out.println("Collection created successfully");

        // 5. List Databases
        List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());

        System.out.println("All databases:");
        databases.forEach(db -> System.out.println(db));
    }
}

