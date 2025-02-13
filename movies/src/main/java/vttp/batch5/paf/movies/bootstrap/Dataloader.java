package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.ZipInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.batch5.paf.movies.repositories.MongoMovieRepository;
import vttp.batch5.paf.movies.repositories.MySQLMovieRepository;
import vttp.batch5.paf.movies.services.LoadFileService;




//please see LoadFileService in the service folder, it contains much of the code for task 2;
public class Dataloader { //IMPLEMENTS COMMANDLINERUNNER to run
  @Autowired
  //please see LoadFileService
  LoadFileService loadFileService;
  //LoadFileService is a java file i used, it is in the service folder to load the sql and mongo queries




//NOTE FOR TASK 2, unable to read from zipped file, this app will read the unzipped file. Able to write data to sql and mongo database
//insertions are done in batches of 25
//transaction is used to rollback
//




  //TODO: Task 2
  @Value("${filelocation}")
    private String filelocation;
    //Allow file location to be input



  @Autowired
  MongoMovieRepository mongoRep;

  @Autowired
  MySQLMovieRepository sqlRep;


  //USE TRANSACTION TO ENSURE WRITE
  @Transactional
  public void writeToDatabases(List<JsonObject> jsonList){
  System.out.println("SERVICE: Trying to WRITING TO DATABASE: app writeToDatabases");
  try {
  mongoRep.batchInsertMovies(jsonList);
  sqlRep.batchInsertMovies(jsonList);
  } catch (Exception exception) {
    System.out.println("FAILED TO WRITE: first item is" + jsonList.getFirst().toString());
    System.err.println(exception.getMessage());
    throw exception;
  }

}


public void withLoop(String file) throws Exception{
        //this was used to read the file, filter the date to 2018
        
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

              //THIS FILTERS THOSE THAT ARE 2018 and higher
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
