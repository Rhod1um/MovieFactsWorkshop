package com.example.moviefactsworkshop.services;

import com.example.moviefactsworkshop.models.Movie;
import com.example.moviefactsworkshop.repositories.MovieRepositoryCSV;
import com.example.moviefactsworkshop.repositories.MovieRepositoryDatabase;

import java.util.*;

public class MovieService{
  private MovieRepositoryCSV movieRepositoryCSV; //dependency injecte - at dette objekt laves et andet sted og smides
  //ind her. Gøres ikke her
  public MovieService(){
    this.movieRepositoryCSV = new MovieRepositoryCSV();
  }


  public Movie getFirst(){
    return movieRepositoryCSV.getOne(0); //hvor sættes hvis ikke hardcoded
  }

  public Movie getRandom() {
    int length = movieRepositoryCSV.getMovies().size();
    Random random = new Random();
    int index = random.nextInt(0, length);
    return movieRepositoryCSV.getRandom(index);
  }

  public List<Movie> getTenSortByPopularity() {
    int length = movieRepositoryCSV.getMovies().size();
    Random random = new Random();
    List<Movie> tenMovies = new ArrayList<>();
    for (int i=0; i<10; i++){
      int index = random.nextInt(0, length);
      tenMovies.add(i, movieRepositoryCSV.getRandom(index));
    }
    //sort
    Collections.sort(tenMovies, new SortPopularity()); //fordi popularity er en string
    // og ikke int sortere den kun det første tal så popularity på 15 og 16 vil ikke sorteres
    // i størst/mindst men bare hvordan de tilfældigvis står i csv filen
    return tenMovies; //den vil bruge List.sort frem for Collections.sort
    //ligesom man skulle bruge Arrays.sort hvis man ville bruge den på normal array?
  }

  public int getHowManyWonAnAward() {
    int awardCount = 0;
    for (Movie m : movieRepositoryCSV.getMovies()){
      if (m.getAwards().equalsIgnoreCase("yes")){
        awardCount++;
      }
    }
    return awardCount;
  }

  public List<Movie> printMoviesWithCertainCharacters(char x, int n) {
    List<Movie> movies = new ArrayList<>();

    for (Movie m : movieRepositoryCSV.getMovies()){

      if (m.getTitle().contains(""+x)){
        char[] title = m.getTitle().toCharArray();
        int charCount=0;

        for (int i=0; i<m.getTitle().length(); i++){

          if (title[i] == x) {
            charCount++;
          }
        }
        if (charCount == n) movies.add(m);
      }
      //if (m.getTitle().contains(Character.toString(x))) alternativ til (""+x)
    }
    return movies;
  }

  public String comparesTwoGenres(String g1, String g2) {
    //tager to genre ind
    //finder alle film for hver genre
    //finder den længste film for hver
    //sammenligner dem og returnerer den længste
    int g1_Length = lengthOfMovie(g1);
    int g2_Length = lengthOfMovie(g2);

    if (g1_Length > g2_Length){
      return g1 + " is longest. Length: " + g1_Length + ". " + g2 + " length: " + g2_Length;
    }
    else if (g1_Length == g2_Length){
      return "The longest movies of each genre have equal lengths. " +
      g1 + " length: " + g1_Length + ". " + g2 + " length: " + g2_Length;
    }
    else return g2 + " is longest. Length: " + g2_Length + ". " + g1 + " length: " + g1_Length;
  }

  public Integer lengthOfMovie(String genre){
    if (genre.equalsIgnoreCase("sciencefiction")){
      genre = "science fiction"; //gøres fordi man taster ind uden mellemrum men i filen er der mellemrum
    }
    Collections.sort(movieRepositoryCSV.getMovies(), new SortLength());
    for (Movie m : movieRepositoryCSV.getMovies()){
      if (m.getSubject().equalsIgnoreCase(genre)){
        return m.getLength(); //returnere det første objekt den rammer med den specificerede
        //genre, hvilket bør være den med længst længde efter Comparator
      }
    }
    return null;
  }

  public String  testSorting() {
    List<String> liste1 = new ArrayList<>();
    liste1.add("1c");
    liste1.add("2b");
    liste1.add("3b");
    liste1.add("3a");
    Collections.sort(liste1, new TestSorting());
    for (String s : liste1){
      if (s.charAt(1) == 'b'){
        return s;
      }
    }
    return null;
  }
}
