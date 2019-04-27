package hello;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class HelloWorld {
	public static void main(String[] args) {
		try {
			//通过连接认证获取MongoDB连接
			MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
			//连接到数据库
			MongoDatabase mongoDatabase = mongoClient.getDatabase("admin");
			System.out.println("Connect to database successfully:"+mongoDatabase.getName());
		} catch (Exception e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
	}
}
