package com.example.moviefactsworkshop.services;

import java.util.Comparator;

public class TestSorting implements Comparator<String> {
  @Override
  public int compare(String o1, String o2) {
    return o2.charAt(0) - (o1.charAt(0));
  }
}
