package com.example.moviefactsworkshop.services;

import com.example.moviefactsworkshop.models.Movie;

import java.util.Comparator;

public class SortLength implements Comparator<Movie> {
  @Override
  public int compare(Movie o1, Movie o2) {
    return o2.getLength().compareTo(o1.getLength());
    //return o2.getLength().compareToIgnoreCase(o1.getLength()); //o2 er først så
    //den største længde kommer først, descending order.
    //naturligt ville tal stige, så derfor er de byttet om.
  }
}
