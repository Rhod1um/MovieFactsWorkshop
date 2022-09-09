package com.example.moviefactsworkshop.models;

public class Movie {
 //når klasse laves så bare autogenerer konstruktør, gettere og settere og toString fra start
  private String year, title, subject, popularity, awards;
  private Integer length;

  public Movie(String year, Integer length, String title, String subject, String popularity, String awards) {
    this.year = year;
    this.length = length;
    this.title = title;
    this.subject = subject;
    this.popularity = popularity;
    this.awards = awards;
  }

  public String getYear() {
    return year;
  }

  public void setYear(String year) {
    this.year = year;
  }

  public Integer getLength() {
    return length;
  }

  public void setLength(Integer length) {
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

  public String getPopularity() {
    return popularity;
  }

  public void setPopularity(String popularity) {
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
    return "Movie{" +
        "year='" + year + '\'' +
        ", length='" + length + '\'' +
        ", title='" + title + '\'' +
        ", subject='" + subject + '\'' +
        ", popularity='" + popularity + '\'' +
        ", awards='" + awards + '\'' +
        '}';
  }
}
