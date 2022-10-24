package com.example.moviefactsworkshop.repositories;

import com.example.moviefactsworkshop.models.Movie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieRepositoryCSV { //klasser under repository kaldes noget med repository
  //henter data fra egen lavet directory ressoruces i roden hvor csv filen af film er lagt
  //kunne ligge alle mulige andre steder men nu ligger den i ressources i roden

  //her skal csv filen læses ind i en arrayliste ligesom vi gjorde sidste semester

  private List<Movie> movies; //har man ikke lavet movie klasse endnu kan man autogenerere og ligge den under models

  public MovieRepositoryCSV(){ //lav altid konstruktør
    this.movies = new ArrayList<>(); //fordel ved linkedlist - skal ikke ændre hver index
    generateMovieList(); //autogenerer metode ud fra metodenavn, men den gør metoden private
  }

  public Movie getOne(int index){
    return movies.get(index);
  }

  private void generateMovieList() { //når scanner der tager fra filen er lavet kommer der rød streg under
    //scanner. vælg rød lightbulb og tryk surround with try and catch
    //læs fra csv fil og tilføj hver movie til listen
    try {
      Scanner sc = new Scanner(new File("/home/veronica/IdeaProjects/2_sem/uge3/MovieFactsWorkshop/ressources/movies.csv"));
      sc.useDelimiter(";|\n"); //ved OR streg, skal der ikke være to streger? claus laver kun en
      //at bruge to streger er javas OR tegn. Men ovennævnte streng er regular expression
      //det er på en måde sit eget sprog. Det er regex som Tobias har snakket om
      //det har sin egen logik og syntax
      //mellemrum betyder noget, det skal være ";|\n" og ikke "; | \n", så giver det NoSuchElementException

      while (sc.hasNext()){ //hasNext ved læsning fra filer
        // Year;Length;Title;Subject;Popularity;Awards
        String year = sc.next();
        Integer length = sc.nextInt();
        String title = sc.next();
        String subject = sc.next();
        String popularity = sc.next();
        String awards = sc.next();

        Movie movie = new Movie(year, length, title, subject, popularity, awards);

        movies.add(movie);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    //find path ved at højreklikke filen og trykke copy path reference. Her er absolute path valgt
    //det gør claus altid men man kan vælge andet også
  }

  public Movie getRandom(int index) {
    return movies.get(index);
  }

  public List<Movie> getMovies(){
    return movies;
  }

}
