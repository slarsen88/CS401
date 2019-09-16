import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LineDelimiterTest
{
    public static void main(String[] args)throws FileNotFoundException
    {

//                String line = "foo,bar,\"baz,blurb\",\"quux,syzygy\"";
//                String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
//                for(String t : tokens) {
//                    System.out.println(t);
//                }


        File file = new File("movie_metadata5.csv");
        Scanner dataScanner = new Scanner(file);
        dataScanner.nextLine();

        while(dataScanner.hasNext())
        {
            String line = dataScanner.nextLine();
            String[] tokens = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
            for (String s: tokens)
            {
                System.out.println(s);
            }
//            Scanner lineScanner = new Scanner(line);
//            lineScanner.useDelimiter(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());
//            System.out.println(lineScanner.next());

        }
    }
}
