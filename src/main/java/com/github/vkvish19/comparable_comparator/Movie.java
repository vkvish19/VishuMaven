package com.github.vkvish19.comparable_comparator;

import java.util.Objects;

public class Movie implements Comparable<Movie>
{
    private String name;
    private int releasedYear;
    private double rating;
    
    public Movie() {}
    
    public Movie(String name, int releasedYear, double rating)
    {
        this.name = name;
        this.releasedYear = releasedYear;
        this.rating = rating;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public int getReleasedYear()
    {
        return releasedYear;
    }
    
    public void setReleasedYear(int releasedYear)
    {
        this.releasedYear = releasedYear;
    }
    
    public double getRating()
    {
        return rating;
    }
    
    public void setRating(double rating)
    {
        this.rating = rating;
    }
    
    @Override
    public String toString()
    {
        return "Movie{" +
                "name='" + name + '\'' +
                ", releasedYear=" + releasedYear +
                ", rating=" + rating +
                '}';
    }
    
    // sorting based on release year
    @Override
    public int compareTo(Movie o)
    {
        return this.releasedYear - o.releasedYear;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie)o;
        return releasedYear == movie.releasedYear && Double.compare(movie.rating, rating) == 0 && name.equals(movie.name);
    }
    
    @Override
    public int hashCode()
    {
        return Objects.hash(name, releasedYear, rating);
    }
}
