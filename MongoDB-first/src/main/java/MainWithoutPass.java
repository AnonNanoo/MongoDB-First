import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MainWithoutPass {
    public static void main(String[] args) {

        // 1. Creating a Mongo client
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        // 2. Creating Credentials
        mongoClient.startSession();

        // 3. Accessing the database
        MongoDatabase database = mongoClient.getDatabase("myDb");
        System.out.println("Connected to the database successfully");
        // Using database
        System.out.println("Collection Names: " + database.listCollectionNames());

        // 4. Creating a collection
        // database.createCollection("sampleCollection");
        // System.out.println("Collection created successfully");

        // 5. List Databases
        //List<Document> databases = mongoClient.listDatabases().into(new ArrayList<>());
        // System.out.println("All databases:");
        // databases.forEach(db -> System.out.println(db));

        // Getting/Selecting a collection
        System.out.println("Collection Names: " + database.listCollectionNames());
        MongoCollection<Document> sampleCollection = database.getCollection("sampleCollection");

        // Insert a Document into sampleCollection
        //System.out.println("Inserting a Document:");
        //Document sampleDocument = new Document("name", "Sample")
        //        .append("type", "example")
        //        .append("count", 1)
        //        .append("info", new Document("x", 100).append("y", 200));
        //sampleCollection.insertOne(sampleDocument);

        // Retrieve all Documents
        System.out.println("All Documents:");
        List<Document> documents = sampleCollection.find().into(new ArrayList<>());
        documents.forEach(doc -> System.out.println(doc));

        // Update Documents
        //System.out.println("Updating Documents:");
        //sampleCollection.updateMany(new Document(name: "Sample", name: "Hihello"),
        //        new Document("$set", new Document("name", "Updated Sample")));


        System.out.println("Updating Documents:");
        sampleCollection.updateMany(new Document("name", "Sample"),
                new Document("$set", new Document("name", "HELLO")));


        //Delete a Document
        //System.out.println("Deleting a Document:");
        //sampleCollection.deleteOne(new Document("name", "Updated Sample"));

        // dropping a collection
        //System.out.println("Dropping a Collection:");
        //sampleCollection.drop();

        // Listing all the Collections
        for (String name : database.listCollectionNames()) {
            System.out.println("Collection Names: " + name);
        }

    }

}