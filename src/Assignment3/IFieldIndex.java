/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This interface is used within MoviesDB to retrieve properties of movies based on the passed in parameters
 */

package Assignment3;

public interface IFieldIndex
{
    public default Object getFieldIndex(Movie m, String field)
    {
        switch(field)
        {
            case "color":
                return m.getColor();
            case "title":
                return m.getMovie_title();
            case "duration":
                return m.getDuration();
            case "director_name":
                return m.getDirector_name();
            case "actor_1_name":
                return m.getActor_1_name();
            case "actor_2_name":
                return m.getActor_2_name();
            case "actor_3_name":
                return m.getActor_3_name();
            case "movie_imdb_link":
                return m.getMovie_imdb_link();
            case "language":
                return m.getLanguage();
            case "country":
                return m.getCountry();
            case "content_rating":
                return m.getContent_rating();
            case "title_year":
                return m.getTitle_year();
            case "imdb_score":
                return m.getImdb_score();

        }

        return null;
    }
}
