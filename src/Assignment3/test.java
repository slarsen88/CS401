//package Assignment3;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.util.HashSet;
//import java.util.Scanner;
//
//public class test
//{
//    private static Movie[] db;
//    private static int lineCount;
//
//    public static void main(String[] args) throws FileNotFoundException
//    {
//        String fileName = "movie_metadata.csv";
//        File file = new File(fileName);
//        int sizeOfArray = numOfEntries(file);
//        db = new Movie[sizeOfArray];
//        Movie movie;
//        int DBIndex = 0;
//        int tokenIndex = 0;
//        Scanner dataScanner = new Scanner(file);
//        // Set all fields of Movie class from reading doc and place into
//        // db
//        dataScanner.nextLine();
//        while(dataScanner.hasNext())
//        {
////            String line = dataScanner.nextLine(); // Reads the entire row into a String
////            String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)"); // Splits the row by , and ignores " "
////            movie = new Movie();
////            for (String token : tokens)
////            {
////                if (!token.isEmpty())
////                {
////                    movie.setId(Integer.parseInt(token));
////                    movie.setColor(token);
////                    movie.setMovie_title(token);
////                    movie.setDuration(Integer.parseInt(token));
////                    movie.setDirector_name(token);
////                    movie.setActor_1_name(token);
////                    movie.setActor_2_name(token);
////                    movie.setActor_3_name(token);
////                    movie.setMovie_imdb_link(token);
////                    movie.setLanguage(token);
////                    movie.setCountry(token);
////                    movie.setContent_rating(token);
////                    movie.setTitle_year(Integer.parseInt(token));
////                    movie.setImdb_score(Double.parseDouble(token));
////                }
////            }
////            db[DBIndex] = movie;
////            DBIndex++;
////            System.out.println(line);
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//            String line = dataScanner.nextLine(); // Reads the entire row into a String
//            Scanner lineScanner = new Scanner(line);
//            lineScanner.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
////            System.out.println(line);
//            movie = new Movie();
//            try
//            {
//                movie.setId(lineScanner.nextInt());
//                movie.setColor(lineScanner.next());
//                movie.setMovie_title(lineScanner.next());
//                movie.setDuration(lineScanner.nextInt());
//                movie.setDirector_name(lineScanner.next());
//                movie.setActor_1_name(lineScanner.next());
//                movie.setActor_2_name(lineScanner.next());
//                movie.setActor_3_name(lineScanner.next());
//                movie.setMovie_imdb_link(lineScanner.next());
//                movie.setLanguage(lineScanner.next());
//                movie.setCountry(lineScanner.next());
//                movie.setContent_rating(lineScanner.next());
//                movie.setTitle_year(lineScanner.nextInt());
//                movie.setImdb_score(lineScanner.nextDouble());
//            }
//            catch (Exception ex)
//            {
//                System.out.println(ex.getMessage());
//                continue;
//            }
//
//            tokenIndex = 0;
//            db[DBIndex] = movie;
//            DBIndex++;
//            System.out.println(movie.getId() + " " + movie.getMovie_title() + " " + movie.getDirector_name() + " " + movie.getTitle_year());
//
//
//        }
//
//    }
//
//    private static int numOfEntries(File file)
//    {
//        try
//        {
//            Scanner dataScanner = new Scanner(file);
//            dataScanner.nextLine(); // skips first line of excel doc
//            lineCount = 0;
//            while (dataScanner.hasNext())
//            {
//                dataScanner.nextLine();
//                lineCount++;
//
//            }
//        }
//        catch (Exception ex)
//        {
//            System.out.println(ex.getMessage());
//        }
//        System.out.println(lineCount);
//        return lineCount;
//    }
//
//
//}
