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

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

public class Dataloader {

  //TODO: Task 2
  
  public void loadFile(String filePath){

     InputStream filInputStream = null;

        try {
            filInputStream = getClass().getResourceAsStream("/movies_post_2010.json");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("cannot read file");
        }
        
        Scanner sc = new Scanner(filInputStream);
        while (sc.hasNext()) {
          JsonReader jsonReader = Json.createReader(new StringReader(sc.next()));
          JsonObject jsonObject = jsonReader.readObject();
          System.out.println("JSONOBJECT trying to read:" + jsonObject.toString());
        }
      /*   JsonReader jsonReader = Json.createReader(filInputStream);
        JsonObject jsonObject = jsonReader.readObject();
        System.out.println("Trying to read file:" + jsonObject.toString());
         */
      
         //list of JsonObjects is created


/*     ZipInputStream zipStream = null;

    try {
      zipStream = new ZipInputStream(getClass().getResourceAsStream("data\\movies_post_2010.zip"));
      System.out.println("CREATED ZIPSTREAM");
      zipStream.getNextEntry();
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("ERROR READING FILE:");
    }
    System.out.println("trying to print file content");
    Scanner sc = new Scanner(zipStream);
    while (sc.hasNextLine()) {
        System.out.println(sc.nextLine());
    }

 */

/*     InputStream filInputStream = null;

        try {
            filInputStream = getClass().getResourceAsStream("/movies_post_2010.zip");
        } catch (Exception e) {
            // TODO: handle exception
        }
        JsonReader JsonReader = Json.createReader(filInputStream);
        System.out.println("Trying to read file:/n:" + JsonReader.toString());
 */

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

            while((null != (line=br.readLine())) && count<10 ){
              count +=1;
              JsonReader jsonReader = Json.createReader(new StringReader(line));
              JsonObject jsonObject = jsonReader.readObject();
              System.out.println("JSONOBJECT trying to read:" + jsonObject.getString("release_date"));
              LocalDate date = LocalDate.parse(jsonObject.getString("release_date"));
              System.out.println("LOCAL DATE PARSE:" + date.getYear());
              if(date.getYear() < 2018){
                System.out.println("THIS ONE IS BEFORE 2018, ignore");
                jsonList.add(jsonObject);
              }

              if(jsonList.size() == 25){
                //use the new transaction class to write the whole list?
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
        }

    }


public void writeToDatabases(List<JsonObject> jsonList){

  
}
  


}
