package com.example.moviefactsworkshop.models;

public class Movie2 {

  //Movie2 er movie med id da databasen skal bruge id
  private String title, subject, awards;
  private int id, year, length, popularity;

  public Movie2(int year, int length, String title, String subject, int popularity, String awards, int id) {
    this.id = id;
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = awards;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public int getPopularity() {
    return popularity;
  }

  public void setPopularity(int popularity) {
    this.popularity = popularity;
  }

  public String getAwards() {
    return awards;
  }

  public void setAwards(String awards) {
    this.awards = awards;
  }

  @Override
  public String toString() {
    return "Movie2{" +
        "id='" + id + '\'' +
        ", year='" + year + '\'' +
        ", length='" + length + '\'' +
        ", title='" + title + '\'' +
        ", subject='" + subject + '\'' +
        ", popularity='" + popularity + '\'' +
        ", awards='" + awards + '\'' +
        '}';
  }
}
