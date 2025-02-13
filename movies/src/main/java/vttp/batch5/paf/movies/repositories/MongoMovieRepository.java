package vttp.batch5.paf.movies.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.Json;
import jakarta.json.JsonObject;

@Repository
public class MongoMovieRepository {

@Autowired
MongoTemplate template;

 // TODO: Task 2.3
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 /* 
Query to Insert Document
  db.imdb.insert({
  _id:,
  imdb_id:,
  title:,
  directors:,
  overview:,
  tagline:,
  genres:,
  imdb_rating:,
  imdb_votes:
  })

  */

 public void batchInsertMovies(List<JsonObject> listOfJsonObjects) {
    System.out.println("TRYING TO BATCH INSERT MONGO");

    try {
        for(JsonObject jsonObject: listOfJsonObjects){
            insertMovie(jsonObject);
        }
        
    } catch (Exception e) {
        // TODO: handle exception

    }


 }


 public void insertMovie(JsonObject j){
    JsonObject jo = Json.createObjectBuilder()
    .add("_id", j.getString("imdb_id"))
    .add("imdb_id", j.getString("imdb_id"))
    .add("title", j.getString("title"))
    .add("director",j.getString("director"))
    .add("overview",j.getString("overview"))
    .add("tagline",j.getString("tagline"))
    .add("genres", j.getString("genres"))
    .add("imdb_rating",j.getInt("imdb_rating"))
    .add("imdb_votes",j.getInt("imdb_votes"))
    .build();
    String jsonStr = jo.toString();
   

    try {
        Document docToInsert = Document.parse(jsonStr);
        Document result = template.insert(docToInsert, "imdb");
    } catch (Exception e) {
        // TODO: handle exception

    }
 } 






 // TODO: Task 2.4
 // You can add any number of parameters and return any type from the method
 // You can throw any checked exceptions from the method
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 /* 
  db.errors.insert({
  ids:,
  error:,
  timestamp:,
  })
  */
 public void logError() {


 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
 //


}
