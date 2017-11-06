package com.zcw;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBTest {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void connMongoDB() {
		MongoClient mongoClient = new MongoClient("localhost", 27017);

		MongoDatabase mongoDatabase = mongoClient.getDatabase("runoob");

		logger.info("Connection to database successfully");

		// mongoDatabase.createCollection("stsColl");

		// logger.info("集合创建成功");

		MongoCollection<Document> collection = mongoDatabase.getCollection("stsColl");
		// logger.info("集合 col1 选择成功");

		/*
		 * Document document = new Document("title", "Redis").append("description",
		 * "database").append("likes", 99) .append("by", "Fly2");
		 * 
		 * List<Document> documents = new ArrayList<>(); documents.add(document);
		 * 
		 * collection.insertMany(documents);
		 * 
		 * logger.info("文档插入成功");
		 */

//		collection.updateMany(Filters.eq("by", "Jackson"), new Document("$set", new Document("by", "Adison")));
		collection.deleteOne(Filters.eq("by", "Adison"));

		FindIterable<Document> findIterable = collection.find();
		MongoCursor<Document> mongoCursor = findIterable.iterator();
		while (mongoCursor.hasNext()) {
			logger.info(mongoCursor.next().toJson());
		}

	}
}
