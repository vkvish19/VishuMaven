package com.github.vkvish19.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class MovieMain
{
    public static void main(String[] args)
    {
        Movie m1 = new Movie("Titanic", 1998, 4.0);
        Movie m2 = new Movie("John Wick", 2001, 4.0);
        Movie m3 = new Movie("Worst movie", 2010, 1.0);
        Movie m4 = new Movie("Okish movie", 1994, 3.0);
        Movie m5 = new Movie("Time waste", 2001, 2.0);
    
        List<Movie> list = new ArrayList<>();
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
    
        System.out.println("list = " + list);
    
        Collections.sort(list);
    
        System.out.println("sorted list = " + list);
    
        System.out.println("Sorting with name comparator : ");
        Collections.sort(list, new NameComparator());
        System.out.println("Name sorted list = " + list);
    
        System.out.println("Sorting with rating comparator : ");
        Collections.sort(list, new RatingComparator());
        System.out.println("Rating sorted list = " + list);
        
        list.sort(new NameComparator());
        System.out.println("list = " + list);
        
    }
}
