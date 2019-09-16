/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This class is a helper class to create graphs via the given data sets.
 */

package Assignment4;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;
import java.util.HashMap;

public class UserArtistRelations
{
    // Creates a Directed Graph for User<->Friend relations
    public static Digraph createUserFriendsGraph()
    {
        String filePath ="C:\\Users\\stuar\\OneDrive\\Documents\\CS401Algorithms\\user_friends.dat";
        In in = new In(filePath);
        Digraph graph = new Digraph(in);
        return graph;
    }


    // Creates an EdgeWeightedDigraph for User->Artist relations and their listen counts
    public static EdgeWeightedDigraph createUserArtistGraph()
    {
        String filePath = "C:\\Users\\stuar\\OneDrive\\Documents\\CS401Algorithms\\user_artists.dat";
        In in = new In(filePath);
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(in);
        return graph;
    }
}
