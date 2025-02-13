package vttp.batch5.paf.movies.repositories;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
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
            Query to Insert Document, values would be next to colons :
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


  /* 
            Query to Insert Document, values would be next to colons :
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
            ids:123,
            error:errormessage,
            timestamp: localTime,
            })
            */
 public void logError(Exception exception) {
    //native mongo query is here
    Date timestamp = new Date();
    JsonObject jo = Json.createObjectBuilder()
    .add("ids", "error id array")
    .add("error", exception.getMessage())
    .add("timestamp", timestamp.toString())
    .build();
    String jsonStr = jo.toString();
   

    try {
        Document docToInsert = Document.parse(jsonStr);
        Document result = template.insert(docToInsert, "imdb");
    } catch (Exception e) {
        System.out.println("Error has been logged");
        // TODO: handle exception

    }
 }

 // TODO: Task 3
 // Write the native Mongo query you implement in the method in the comments
 //
 //    native MongoDB query here
            /* 
            db.imdb.aggregate([
            {$group:{
                _id: "$director",
                movies_count:{$sum:1},
                movie_ids:{$push:"$imdb_id"},
            }},
            {$sort:{movies_count: -1}},
            {$limit:5}

            ])

  */
public List<Document> getDirectorsWithMostMovies(int limit){
    GroupOperation groupByDirector = Aggregation.group("director")
    .count().as("movies_count").push("imdb_id").as("movie_ids");

    SortOperation sortByMovieCount = Aggregation.sort(Sort.by(Direction.DESC,"movies_count"));
    LimitOperation limits = Aggregation.limit(limit);
    Aggregation pipeline = Aggregation.newAggregation(groupByDirector,sortByMovieCount,limits);
    AggregationResults<Document> results = template.aggregate(pipeline, "imdb",Document.class);
    System.out.println("completed aggregation");
    return results.getMappedResults();
}


}
