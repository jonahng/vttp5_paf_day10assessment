package vttp.batch5.paf.movies.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;

@Repository
public class MySQLMovieRepository {
  @Autowired
  JdbcTemplate template;

  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method

  //insert 25 movies? using a list of documents
  public void batchInsertMovies(List<JsonObject> jsonList) {
    for(JsonObject j : jsonList){
      insertMovie(j);
    }
  }

  public void insertMovie(JsonObject j){
    int added = template.update(SQLQueries.SQLInsert, j.getString("imdb_id"),
     j.getInt("vote_average"),j.getInt("vote_count"),j.getString("release_date"),
     j.getInt("revenue"),j.getInt("budget"),j.getInt("runtime"));
     System.out.println("ADDED TO SQL:" + j.getString("imdb_id"));
  }



  
  // TODO: Task 3


}
