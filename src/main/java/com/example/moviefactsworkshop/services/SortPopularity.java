package com.example.moviefactsworkshop.services;

import com.example.moviefactsworkshop.models.Movie;

import java.util.Comparator;

public class SortPopularity implements Comparator<Movie> {
  @Override
  public int compare(Movie o1, Movie o2) {
    return o1.getPopularity().compareToIgnoreCase(o2.getPopularity());
  }
}
