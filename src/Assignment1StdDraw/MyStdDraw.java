package Assignment1StdDraw;

import edu.princeton.cs.algs4.StdDraw;

public class MyStdDraw
{
    public static void main(String[] args)
    {
        StdDraw.setPenRadius(0.01);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.circle(.5, .4, .02);
        StdDraw.circle(.35, .65, .05);
        StdDraw.circle(.65, .65, .05);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(.3, .2, .7, .2);
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.square(.5, .5, .35);
        StdDraw.rectangle(.13, .60, .02, .05);
        StdDraw.rectangle(.87, .60, .02, .05);
    }
}
