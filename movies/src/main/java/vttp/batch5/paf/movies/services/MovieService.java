package vttp.batch5.paf.movies.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;

@Service
public class MovieService {
  @Autowired
  MongoMovieRepository mongoRepo;

  @Autowired
  MySQLMovieRepository sqlRepo;

  // TODO: Task 2
  //CODE FOR TASK 2 is included inside LoadFileService.java in the service folder.
  

  // TODO: Task 3
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void getProlificDirectors() {
    //In mongo, use aggregation to get the number of movies for each director, and get the count. Also get an array of the IMDB ids for their movies
    //use the imdb ids to check sql for the total revenue and budget
    System.out.println("Trying to find prolific directors...");
    List<Document> highestDirectors = mongoRepo.getDirectorsWithMostMovies(5);
    for(Document d : highestDirectors){
      System.out.println("THE MOVIE IDS ARE:" + d.getList("movie_ids", String.class));
    }


  }


  // TODO: Task 4
  // You may change the signature of this method by passing any number of parameters
  // and returning any type
  public void generatePDFReport() {

  }

}
