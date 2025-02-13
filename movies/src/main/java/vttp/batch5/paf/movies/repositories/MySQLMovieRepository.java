package vttp.batch5.paf.movies.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import jakarta.json.JsonObject;
import vttp.batch5.paf.movies.models.MovieFinance;

@Repository
public class MySQLMovieRepository {
  @Autowired
  JdbcTemplate template;

  // TODO: Task 2.3
  // You can add any number of parameters and return any type from the method

  //insert 25 movies? using a list of documents
  public void batchInsertMovies(List<JsonObject> jsonList) {
    try {
      for(JsonObject j : jsonList){
        insertMovie(j);
      }
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("ERROR BATCH INSERT SQL MOVIES" + e.getMessage());

    }
   
  }

  public void insertMovie(JsonObject j){
    try {
      int added = template.update(SQLQueries.SQLInsert, 
      j.getString("imdb_id"),
      j.getInt("vote_average"),
      j.getInt("vote_count"),
      j.getString("release_date"),
      j.getInt("revenue"),
      j.getInt("budget"),
      j.getInt("runtime"));
      System.out.println("ADDED TO SQL:" + j.getString("imdb_id"));
    } catch (Exception e) {
      // TODO: handle exception
    
      System.out.println("EXCEPTION E" + e.getMessage());

    }

  }



  
  // TODO: Task 3

  public MovieFinance getSpecificMovieDetails(String movieId){
    SqlRowSet rs = template.queryForRowSet(SQLQueries.SQLGetSpecificMovieDetails,movieId);
    MovieFinance mf = new MovieFinance();
    while (rs.next()) {
      
      System.out.println("ONE PIECE OF REVENUE IS:" + rs.getDouble("revenue") );
      mf.setRevenue(rs.getDouble("revenue"));
      mf.setBudget(rs.getDouble("budget"));
    }
    return mf;


  }


}
