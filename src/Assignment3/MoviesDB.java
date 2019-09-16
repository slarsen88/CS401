/*
        Author: Stuart Larsen
        Date: 5/28/2019
        Course: Algorithms Winter 2019
        Assignment: 3
        Instructor: Fatma Serce
        Synopsis: This program creates a DB of movies using Red Black Trees. The client is able to run queries on the DB
        using the Query class.
 */
package Assignment3;

import edu.princeton.cs.algs4.RedBlackBST;
import edu.princeton.cs.algs4.StdOut;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MoviesDB<T extends Comparable<T>> implements IFieldIndex
{
    private static String fileName = "movie_metadata.csv";
    private Map<String, RedBlackBST<T, HashSet<Integer>>> indexTreeMap
            = new HashMap<String, RedBlackBST<T, HashSet<Integer>>>();
    private Movie[] db;
    private static int lineCount;

    public static void main(String[] args) throws FileNotFoundException
    {
        MoviesDB movieDB = new MoviesDB(fileName);
        // *********** Test cases *****************8
//        movieDB.addFieldIndex("title_year");
//        Query<Integer> query = new Equal("title_year", 1916);
//        movieDB.addFieldIndex("imdb_score");

//        movieDB.addFieldIndex("title");
//        Query<Integer> query = new GT("title", "Age of Ultron");
//        Query<Integer> query = new GTE("imdb_score", 9.0);
//        Query<Integer> query = new Not(new Equal("year", 2012));
//        movieDB.addFieldIndex("duration");
//        Query<Integer> query = new Equal("imdb_score", 9.0);
        movieDB.addFieldIndex("color");
        Query<Integer> query = new Equal("color", "Color");

//        Query<Integer> query = new LT("duration", 14);
//        Query<Integer> query = new Or(new Equal("title_year", 1937), new GTE("imdb_score", 6.0));
//        Query<Integer> query = new And(new LT("imdb_score", 9.1), new GT("imdb_score", 8.8));
//        Query<Integer> query = new Not(new Equal("title_year", 1916));
//        Query<Integer> query = new LT("duration", 300);
//        Query<Integer> query = new Equal("color", "Color");
        HashSet<Integer> result = (HashSet<Integer>) query.execute(movieDB.getIndexTreeMap());

        if (result != null)
        {
            System.out.println(result);
        }

        if (result.isEmpty())
        {
            throw new IllegalArgumentException();
        }

        int movieCount = 0;
        Iterator<Integer> idIterator = result.iterator();
        while (idIterator.hasNext())
        {
            movieCount++;
            int id = idIterator.next();
            movieDB.print(id);
        }
        System.out.println("There were: " + movieCount + " movie(s) returned in this query");
    }

    // Prints all of the IDs of the movies found within the query
    private void print(int id)
    {
        System.out.println("-----------------");
        System.out.println("id:" + db[id - 1].getId());
        System.out.println("color:" + db[id-1].getColor());
        System.out.println("Title:" + db[id-1].getMovie_title());
        System.out.println("Duration: " + db[id-1].getDuration());
        System.out.println("Director: " + db[id-1].getDirector_name());
        System.out.println("Actor 1: " + db[id-1].getActor_1_name());
        System.out.println("Actor 2: " + db[id-1].getActor_2_name());
        System.out.println("Actor 3: " + db[id-1].getActor_3_name());
        System.out.println("IMDB Link: " + db[id-1].getMovie_imdb_link());
        System.out.println("Language: " + db[id-1].getLanguage());
        System.out.println("Country: " + db[id-1].getCountry());
        System.out.println("Year: " + db[id-1].getTitle_year());
        System.out.println("Imdb Score: " + db[id-1].getImdb_score());
        System.out.println("-----------------");
        System.out.println();
    }

    // Read through CSV and input movie data into array of Movie objects.
    // Also checks for any gaps in CSV and handles missing data
    public MoviesDB(String fileName) throws FileNotFoundException
    {
        File file = new File(fileName);
        int sizeOfArray = numOfEntries(file);
        db = new Movie[sizeOfArray];
        Movie movie;
        int DBIndex = 0;
        Scanner dataScanner = new Scanner(file);
        dataScanner.nextLine();
        while(dataScanner.hasNext())
        {
            String line = dataScanner.nextLine(); // Reads the entire row into a String
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // delimits line by commas, but ignores commas inside quotes
            movie = new Movie();

            movie.setId(lineScanner.nextInt());
            String color = lineScanner.next();
            if (color.isEmpty())
            {
                movie.setColor("null");
            } else
            {
                movie.setColor(color);
            }

            String movieTitle = lineScanner.next();
            if (movieTitle.isEmpty())
            {
                movie.setMovie_title("null");
            } else
            {
                movie.setMovie_title(movieTitle);
            }

            if (lineScanner.hasNextInt())
            {
                movie.setDuration(lineScanner.nextInt());
            } else
            {
                movie.setDuration(-1);
                lineScanner.next();
            }

            String director = lineScanner.next();
            if (director.isEmpty())
            {
                movie.setDirector_name("null");
            } else
            {
                movie.setDirector_name(director);
            }

            String actor1 = lineScanner.next();
            if (actor1.isEmpty())
            {
                movie.setActor_1_name("null");
            } else
            {
                movie.setActor_1_name(actor1);
            }

            String actor2 = lineScanner.next();
            if (actor2.isEmpty())
            {
                movie.setActor_2_name("null");
            } else
            {
                movie.setActor_2_name(actor2);
            }

            String actor3 = lineScanner.next();
            if (actor3.isEmpty())
            {
                movie.setActor_3_name("null");
            } else
            {
                movie.setActor_3_name(actor3);
            }

            String imdb_link = lineScanner.next();
            if (imdb_link.isEmpty())
            {
                movie.setMovie_imdb_link("null");
            } else
            {
                movie.setMovie_imdb_link(imdb_link);
            }

            String language = lineScanner.next();
            if (language.isEmpty())
            {
                movie.setLanguage("null");
            } else
            {
                movie.setLanguage(language);
            }

            String country = lineScanner.next();
            if (country.isEmpty())
            {
                movie.setCountry("null");
            } else
            {
                movie.setCountry(country);
            }

            String rating = lineScanner.next();
            if (rating.isEmpty())
            {
                movie.setContent_rating("null");
            }
            else
            {
                movie.setContent_rating(rating);
            }

            if (lineScanner.hasNextInt())
            {
                movie.setTitle_year(lineScanner.nextInt());
            }
            else
            {
                movie.setTitle_year(-1);
                lineScanner.next();
            }

            if (lineScanner.hasNextDouble())
            {
                movie.setImdb_score(lineScanner.nextDouble());
            }
            else
            {
                movie.setImdb_score(0.0);
            }

            db[DBIndex] = movie;
            DBIndex++;
        }
    }

    // Create a new red black tree by the given field
    public void addFieldIndex(String field)
    {
        RedBlackBST<T, HashSet<Integer>> fieldIndexBST = new RedBlackBST<>();
        for (Movie movie : db)
        {
            T movieProperty = (T) getFieldIndex(movie, field);
            addItemToTree(fieldIndexBST, movie, movieProperty);
        }

        indexTreeMap.put(field, fieldIndexBST);
    }

    // Adds the key/value(set of IDs) node to the RBT
    private void addItemToTree(RedBlackBST<T, HashSet<Integer>> fieldIndexBST, Movie movie, T movieProperty)
    {
        if (!fieldIndexBST.contains(movieProperty))
        {
            HashSet<Integer> firstItem = new HashSet<Integer>();
            firstItem.add(movie.getId());
            fieldIndexBST.put(movieProperty, firstItem);
        }
        else
        {
            HashSet<Integer> IDs = new HashSet<>();
            IDs = fieldIndexBST.get(movieProperty);
            IDs.add(movie.getId());
            fieldIndexBST.put(movieProperty, IDs);
        }
    }

    // Returns hashMap for index trees (RBTs)
    public Map<String, RedBlackBST<T, HashSet<Integer>>> getIndexTreeMap()
    {
        return indexTreeMap;
    }

    // Traverses through excel doc to find out how many entries there are in order to instantiate Movie[] with proper size
    private static int numOfEntries(File file)
    {
        try
        {
            Scanner dataScanner = new Scanner(file);
            dataScanner.nextLine(); // skips first line of excel doc
            lineCount = 0;
            while (dataScanner.hasNext())
            {
                dataScanner.nextLine();
                lineCount++;
            }
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        return lineCount;
    }
}
