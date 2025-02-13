package vttp.batch5.paf.movies.bootstrap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
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
            FileReader fr = new FileReader("/movies_post_2010.json");
            BufferedReader br = new BufferedReader(fr);
            br.readLine(); //this discards the header first line
            String line;
            while(null != (line=br.readLine())){
              JsonReader jsonReader = Json.createReader(new StringReader(line));
              JsonObject jsonObject = jsonReader.readObject();
              System.out.println("JSONOBJECT trying to read:" + jsonObject.toString());
        
                //create your object, like customer or smth
                //set the object to fields[1] etc on the object using object setters
                //create list of the object, customers.add(customer)
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

    }


public void writeJsonToApp(){
  //List of JsonObjects obtained
   /* 
   both inputs are jsonObjects
   use while loops?
    mongo repo write to mongo:
    mysql repo write to sql
    */
}
  


}
