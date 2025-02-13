package vttp.batch5.paf.movies.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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

 public void batchInsertMovies() {

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
