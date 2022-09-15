package com.example.moviefactsworkshop.controllers;

import com.example.moviefactsworkshop.models.Movie;
import com.example.moviefactsworkshop.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //skal være der for det virker med frameworket
public class MovieController {
  //request fra brugeren kommer ind her
  //POJO fil - java jagon - plan over java object - fx movie under model
  //repositories - læser databaser, json api fx
  //services - databehandling

  //spring initializr - siger til java den skal have url ind? start url start.spring.io
  //kan trykkes på når man laver projekt
  //pom.xml fil er dependencies med i projektet
  //under start.spring.io er de samme ting som intellij selv tager med når man laver et spring projekt

  //kan man inkludere thymeleaf senere? eller kun ved projekt start?
  //hvor kommer maven ind? kom ikke ind automatisk

  //for at port8080 ikke er in use så bare terminate det projekt der køre. Det køre jo indtil man slukker det

  //endpoint: en url man kan gå ind på

  private MovieService movieService;

  public MovieController(){
    this.movieService = new MovieService();
  } //denne klasse laves i main

  //hvid pil - komposition
  //sort pil - aggregation - klasse findes kun hvis en anden findes

  //exercise 2
  @GetMapping("/getfirst")
  public Movie getFirst(){ //skal finde første movie i service. Her laves ikke databeregning men princippet
    //controller skal snakke med service (servicelag), ikke repository. Service snakker så med repository, som snakker
    //med csv filen eller en database. Gøres kun den rækkefølge
    //hver klasse laver objekt af den næste klasse der skal kaldes.
    //controller laver service, service laver repo.
    //alle klasser gør dog brug af model
    return movieService.getFirst(); //ingen argumenter i controller, ingen logik
  } //skal returnere datatype Movie til brugeren

  @GetMapping("/random") //normalt giv endpoint samme ("/random") samme navn som metoden
  //men gør hvad der giver mening
  public Movie getRandom(){
    return movieService.getRandom();
  }
  @GetMapping("/popularity")
  public List<Movie> getTenSortByPopularity(){
    return movieService.getTenSortByPopularity();
  }
  @GetMapping("/award")
  public String getHowManyWonAnAward(){
    return "Movies that won an award: " + movieService.getHowManyWonAnAward();
  }
  @GetMapping("/filter") //skriv localhost:8080/filter?x=x&n=n
  public List<Movie> printMoviesWithCertainCharacters(char x, int n, int xxx){
    //man behøver ikke skrive @RequestParam
    //man skal skrive alle parametre ind i urlen, selv hvis de ikke bruges^^
    //bliver localhost:8080/filter?x=x&n=n&xxx=et_tal
    return movieService.printMoviesWithCertainCharacters(x, n);
  }
  @GetMapping("/longest") //skriv localhost:8080/longest?g1=drama&g2=westerns
  public String comparesTwoGenres(String g1, String g2){
    return movieService.comparesTwoGenres(g1, g2);
  } //hvor skal comparatorklasser ligge? services?

  @GetMapping("/testsorting")
  public String testSorting(){
    return movieService.testSorting();
  }

  //claus har installeret et browser plugin som viser de her udprintede arrays af film som json
  //så det vises pænt
}
