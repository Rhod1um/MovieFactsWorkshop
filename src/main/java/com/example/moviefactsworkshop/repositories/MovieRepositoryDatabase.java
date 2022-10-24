package com.example.moviefactsworkshop.repositories;

import com.example.moviefactsworkshop.models.Movie2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MovieRepositoryDatabase {

  private Connection connection = DatabaseManager.getConnection(); //skal
  //tages ind så man kan hente ting fra databasen og sætte det i listen

  //metode der tager ting fra databasen og ligger det i liste.
  //Student klasse er entity klasse som databaseinstanser laves til
  //gøres på samme måde som med csv fil

  public List<Movie2> getAllMovies(){
    List<Movie2> movies = new ArrayList<>();

    //PreparedStatement preparedStatement = null; //claus kunne godt instantiere
    //preparedStatement direkte i try catch men her vil den lave den først med null
    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies");
      //laver et objekt med sql statements
      ResultSet resultSet = preparedStatement.executeQuery(); //executer det ovenover
      //while executer det for hver student.

      while (resultSet.next()){ //gøres som csv
        movies.add(new Movie2(
            resultSet.getInt("year"),
            resultSet.getInt("length"),
            resultSet.getString("title"),
            resultSet.getString("subject"),
            resultSet.getInt("popularity"),
            resultSet.getString("awards"),
            resultSet.getInt("id")
        ));
      }

    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return movies;
  }

  //metode som returnere enkelt movie frem for hele tabellen
  public Movie2 getMovie(int id){
    //samme som tidligere men uden arrayliste
    try{
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM movies WHERE id=?");
      //spørgsmålstegnet undgår sql injections
      preparedStatement.setInt(1, id); //parameterindex er første ? i query
      ResultSet resultSet = preparedStatement.executeQuery();

      if (resultSet.next()){ //if frem for while da vi kun skal have én og ikke loope gennem arrayliste
        return new Movie2( //får fat i en enkelt student
            resultSet.getInt("year"),
            resultSet.getInt("length"),
            resultSet.getString("title"),
            resultSet.getString("subject"),
            resultSet.getInt("popularity"),
            resultSet.getString("awards"),
            resultSet.getInt("id")
        );
      }

    } catch (SQLException e){
      throw new RuntimeException(e);
    }

    return null;
  }
//kør dette fra MySqlForbindTilDatabaseApplication for at få det på localhost
  //kør ikke fra Main klasse
}
