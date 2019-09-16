/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This class is a blueprint for the Movie object. It has properties for all columns found in the excel sheet
        that is parsed in the MoviesDB.java class
 */

package Assignment3;

public class Movie
{
    private int id;
    private String color;
    private String movie_title;
    private int duration;
    private String director_name;
    private String actor_1_name;
    private String actor_2_name;
    private String actor_3_name;
    private String movie_imdb_link;
    private String language;
    private String country;
    private String content_rating;
    private int title_year;
    private double imdb_score;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getMovie_title()
    {
        return movie_title;
    }

    public void setMovie_title(String movie_title)
    {
        this.movie_title = movie_title;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }

    public String getDirector_name()
    {
        return director_name;
    }

    public void setDirector_name(String director_name)
    {
        this.director_name = director_name;
    }

    public String getActor_1_name()
    {
        return actor_1_name;
    }

    public void setActor_1_name(String actor_1_name)
    {
        this.actor_1_name = actor_1_name;
    }

    public String getActor_2_name()
    {
        return actor_2_name;
    }

    public void setActor_2_name(String actor_2_name)
    {
        this.actor_2_name = actor_2_name;
    }

    public String getActor_3_name()
    {
        return actor_3_name;
    }

    public void setActor_3_name(String actor_3_name)
    {
        this.actor_3_name = actor_3_name;
    }

    public String getMovie_imdb_link()
    {
        return movie_imdb_link;
    }

    public void setMovie_imdb_link(String movie_imdb_link)
    {
        this.movie_imdb_link = movie_imdb_link;
    }

    public String getLanguage()
    {
        return language;
    }

    public void setLanguage(String language)
    {
        this.language = language;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getContent_rating()
    {
        return content_rating;
    }

    public void setContent_rating(String content_rating)
    {
        this.content_rating = content_rating;
    }

    public int getTitle_year()
    {
        return title_year;
    }

    public void setTitle_year(int title_year)
    {
        this.title_year = title_year;
    }

    public double getImdb_score()
    {
        return imdb_score;
    }

    public void setImdb_score(double imdb_score)
    {
        this.imdb_score = imdb_score;
    }

}
