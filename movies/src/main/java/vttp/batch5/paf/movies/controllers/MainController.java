package vttp.batch5.paf.movies.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vttp.batch5.paf.movies.bootstrap.Dataloader;
import vttp.batch5.paf.movies.services.LoadFileService;
import vttp.batch5.paf.movies.services.MovieService;

@RestController
@RequestMapping("")
public class MainController {
  @Autowired
  LoadFileService loadFileService;

  @Autowired
  MovieService movieService;


  @GetMapping("/loadfile")
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


  @GetMapping("/top")
  public void getTopDirectors(){
    movieService.getProlificDirectors();
  }


  // TODO: Task 3
   

  
  // TODO: Task 4


}
