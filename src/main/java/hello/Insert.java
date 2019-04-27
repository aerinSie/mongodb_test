package hello;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.CreateCollectionOptions;
import org.bson.Document;

import java.util.Arrays;

public class Insert {
	public static void main(String[] args) {
		try {
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			MongoDatabase admindb = mongoClient.getDatabase("admin");
			System.out.println("Connect to database successfully:"+admindb.getName());

			MongoDatabase database = mongoClient.getDatabase("admin");
			MongoCollection<Document> collection = database.getCollection("employees");

//insert
			Document employee = new Document()
					.append("first_name", "Joe")
					.append("years_of_service", 3)
					.append("skills", Arrays.asList("java", "spring", "mongodb"))
					.append("manager", new Document()
							.append("first_name", "Sally")
							.append("last_name", "Johanson"));
			collection.insertOne(employee);

		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
