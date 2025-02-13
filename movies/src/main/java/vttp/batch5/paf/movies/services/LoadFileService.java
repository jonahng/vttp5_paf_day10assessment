package vttp.batch5.paf.movies.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;

@Service
public class LoadFileService {
  @Autowired
  MongoMovieRepository mongoRep;

  @Autowired
  MySQLMovieRepository sqlRep;


  //USE @Transactional to ensure all writes
  @Transactional
public void writeToDatabases(List<JsonObject> jsonList){
  System.out.println("SERVICE: Trying to WRITING TO DATABASE: app writeToDatabases");
  try {
  mongoRep.batchInsertMovies(jsonList);
  sqlRep.batchInsertMovies(jsonList);
  } catch (Exception exception) {
    System.out.println("FAILED TO WRITE: firs item is" + jsonList.getFirst().toString());
    System.err.println(exception.getMessage());
    mongoRep.logError(exception);
    throw exception;
  }

}


public void withLoop(String file) throws Exception{
        //List<Customer> customers = new ArrayList<>();
        try {
          System.out.println("TRYING TO READ FILE");
            FileReader fr = new FileReader("C:\\Users\\65932\\vttp5_paf_day10a\\movies\\src\\main\\resources\\movies_post_2010.json");
            BufferedReader br = new BufferedReader(fr);
            String line;
            int count = 0;

            
            List<JsonObject> jsonList = new ArrayList<>();

            while((null != (line=br.readLine())) ){
              count +=1;
              JsonReader jsonReader = Json.createReader(new StringReader(line));
              JsonObject jsonObject = jsonReader.readObject();
              System.out.println("JSONOBJECT trying to read:" + jsonObject.getString("release_date"));
              LocalDate date = LocalDate.parse(jsonObject.getString("release_date"));
              System.out.println("LOCAL DATE PARSE:" + date.getYear());
              if(date.getYear() > 2017){
                //System.out.println("THIS ONE IS BEFORE 2018, ignore");
                jsonList.add(jsonObject);
              }

              if(jsonList.size() == 25){
                //use the new transaction class to write the whole list?
                writeToDatabases(jsonList);
                //writeToDatabases(jsonList);

                jsonList.clear();
              }
              //if date > than 2018, add to list OK
              //if list.size is 25, write it? write using a new class, with transactional?
              //done in this while loop?
        
                //create your object, like customer or smth
                //set the object to fields[1] etc on the object using object setters
                //create list of the object, customers.add(customer)
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("problems writing");
        }

    }


}
