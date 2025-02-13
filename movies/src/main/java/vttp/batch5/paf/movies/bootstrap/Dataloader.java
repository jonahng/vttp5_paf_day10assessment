package vttp.batch5.paf.movies.bootstrap;

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


}
