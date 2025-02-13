package vttp.batch5.paf.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.movies.bootstrap.Dataloader;
import vttp.batch5.paf.movies.services.LoadFileService;

@RestController
@RequestMapping("")
public class MainController {
  @Autowired
  LoadFileService loadFileService;


  @GetMapping("loadfile")
  public void loadFile(){
    Dataloader dataloader = new Dataloader();
    //dataloader.loadFile(null);
    try {
      //dataloader.withLoop("abc");
      loadFileService.withLoop(null);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }


  // TODO: Task 3
   

  
  // TODO: Task 4


}
