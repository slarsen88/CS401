/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This program implements the ILastFM interface and uses given data sets to print out simple querires
                  such as "List top 10 artists" or "List friends of friends"
 */

package Assignment4;

import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Stack;

import java.util.*;


public class RecommenderSystem implements ILastFM
{
    static Digraph userFriendsGraph;
    static EdgeWeightedDigraph userArtistGraph;
    static HashMap<Integer, Artist> artistMap;

    // When object is created, build graph relations
    public RecommenderSystem()
    {
        UserArtistRelations relations = new UserArtistRelations();
        userArtistGraph = relations.createUserArtistGraph();
        userFriendsGraph = relations.createUserFriendsGraph();
        artistMap = parseArtists();
    }

    // given a userID, print out the top 10 listened to artists of the given user and his/her friends
    public void recommend10(int user)
    {
        HashMap<Integer, Artist> recommendedArtists = new HashMap<>();
        MinPQ<Artist> pq = new MinPQ<>();

        // Add artists the given user has listened to to a hash map
        for (DirectedEdge edge : userArtistGraph.adj(user))
        {
            Artist artist = new Artist();
            addArtistToRecommendedList(recommendedArtists, edge, artist);
        }

        // Iterate over friends list and do the same logic as above
        for (int v : userFriendsGraph.adj(user))
        {
            for (DirectedEdge edge: userArtistGraph.adj(v))
            {
                Artist artist = new Artist();
                if (!recommendedArtists.containsKey(edge.to())) // If artist is not in hash map, add it
                {
                    addArtistToRecommendedList(recommendedArtists, edge, artist);
                }
                else if (recommendedArtists.get(edge.to()).getListeningCount() < edge.weight()) // Add higher listening count
                {
                    addArtistToRecommendedList(recommendedArtists, edge, artist);
                }
            }
        }

        // Iterate over all artists in hash map and add top 10 to a MinPQ
        int i = 1;
        for (Integer x : recommendedArtists.keySet())
        {
            if (i <= 10)
            {
                pq.insert(recommendedArtists.get(x));
                i++;
            }
            else if(recommendedArtists.get(x).getListeningCount() > pq.min().getListeningCount())
            {
                pq.delMin();
                pq.insert(recommendedArtists.get(x));
            }
        }

        // Add PQ values to a stack to print artists in order
        Stack<Artist> top10Artists = sort10Artists(pq);

        System.out.println("The top 10 Recommended Artists for user " + user  +" are:\n------------------------");
        for (Artist top10Artist : top10Artists)
        {
            System.out.println(top10Artist.getName() + " - Listen Count: " + top10Artist.getListeningCount());
        }
    }

    // Helper method for recommend10 and listTop10
    // Puts the 10 artists in order of listen count
    private Stack<Artist> sort10Artists(MinPQ<Artist> pq)
    {
        Stack<Artist> top10Artists = new Stack<>();
        for (int j = 0; j < 10; j++)
        {
            top10Artists.push(pq.delMin());
        }
        return top10Artists;
    }

    // Builds Artist object and puts object into HashMap<Integer, Artist>
    private void addArtistToRecommendedList(HashMap<Integer, Artist> recommendedArtists, DirectedEdge edge, Artist artist)
    {
        artist.setId(edge.to());
        artist.setName(artistMap.get(edge.to()).getName());
        artist.setListeningCount(edge.weight());
        recommendedArtists.put(edge.to(), artist);
    }

    // Prints the top 10 artists based on listen count across all users
    public void listTop10()
    {
        Artist artist;
        // Iterate over the adjacency lists of all user<-> friend relation
        for (int i = 0; i < userFriendsGraph.V(); i++)
        {
        //  Iterate over each adjacency list in the user->artist relation
            for (DirectedEdge edge : userArtistGraph.adj(i))
            {
                if (artistMap.containsKey(edge.to())) // If map already contains artist, add weights
                {
                    artist = artistMap.get(edge.to());
                    artist.setListeningCount(artist.getListeningCount() + edge.weight());
                    artistMap.put(edge.to(), artist);
                }
            }
        }

        // Loop over hash map and add Artists values to minPQ to get the top 10 listened to artists
        MinPQ<Artist> pq = new MinPQ<>();
        for (int i = 1; i < artistMap.size(); i++)
        {
            if (artistMap.get(i) != null)
            {
                if (i <= 10) // Add the first 10 elements into the PQ
                {
                    pq.insert(artistMap.get(i));
                }
                // If the minimum value in the PQ is < next item in the map, delete old min and add new value
                else if (artistMap.get(i).getListeningCount() > pq.min().getListeningCount())
                {
                    pq.delMin();
                    pq.insert(artistMap.get(i));
                }
            }
        }

        // Helper method for recommend10 and listTop10
        // Puts the 10 artists in order of listen count
        Stack<Artist> top10Artists = sort10Artists(pq);

        System.out.println("The top 10 artists are:\n------------------------");
        for (Artist top10Artist : top10Artists)
        {
            System.out.println(top10Artist.getName() + " - Listen Count: " + top10Artist.getListeningCount());
        }
    }

    // Helper function for listTop10
    // Reads file and puts all Artists and their properties into a hash map
    private HashMap<Integer, Artist> parseArtists()
    {
        HashMap<Integer, Artist> artistMap = new HashMap<>();
        String filePath = "C:\\Users\\stuar\\OneDrive\\Documents\\CS401Algorithms\\artists.dat";
        In in = new In(filePath);
        in.readLine();
        while (in.hasNextLine())
        {
            StringBuilder artistName = new StringBuilder();
            Artist artist = new Artist();
            artist.setId(in.readInt());
            String[] line = in.readLine().split("\t");
            for (int i = 1; i < line.length - 2; i++)
            {
                artistName.append(line[i]);
            }
            artist.setName(artistName.toString());
            artistMap.put(artist.getId(), artist);
        }
        return artistMap;
    }

    // Prints artists that both given inputs have in common
    public void listArtists(int user1, int user2)
    {
        boolean hasArtistInCommon = false;
        Artist artist;
        StringBuilder commonArtists = new StringBuilder();
        if (artistMap.get(user1) != null)
        {
            for (DirectedEdge artistUser1 : userArtistGraph.adj(user1)) // Iterate over all of user1's artists
            {
                for (DirectedEdge artistUser2 : userArtistGraph.adj(user2)) // Iterate over all the artists user 1's friends listen to
                {
                    if (artistUser1.to() == artistUser2.to())
                    {
                        artist = artistMap.get(artistUser1.to());
                        commonArtists.append("\t\n" + artist.getName());
                        hasArtistInCommon = true;
                    }
                }
            }
        }
        if (hasArtistInCommon)
        {
            System.out.println((user1 + " and " + user2 + " listen to the following artists: " + commonArtists));
        }
        else
        {
            System.out.println(user1 + " and " + user2 + " do not listen to the same artists.");
        }
    }


    // Print the friends user1 and user2 have in common
    public void commonFriends(int user1, int user2)
    {
        boolean hasCommonFriends = false;
        StringBuilder friendsOfFriends = new StringBuilder();

        for (int friendsOfUser1 : userFriendsGraph.adj(user1)) // Iterate over user1's friends list
        {
            for (int friendsOfUser2 : userFriendsGraph.adj(user2)) // Iterate over user2's friends list
            {
                if (friendsOfUser1 == friendsOfUser2)
                {
                    friendsOfFriends.append(friendsOfUser1 + " ");
                    hasCommonFriends = true;
                }
            }
        }

        if (hasCommonFriends)
        {
            System.out.println(("Friends of " + user1 + " and " + user2 + " are: " + friendsOfFriends)) ;
        }
        else
        {
            System.out.println("Users " + user1 + " and " + user2 + " don't have any friends in common");
        }
    }

    // Prints out the friends list of the given user
    // Uses adjacency list of given user
    public void listFriends(int user)
    {
        Iterable<Integer> test = userFriendsGraph.adj(user);
        if (test.iterator().hasNext())
        {
            System.out.print("Friends of " + user + ": ");
            for (int friend : userFriendsGraph.adj(user)) // Iterate over friends list and print out friends
            {
                System.out.print(friend + " ");
            }
            System.out.println();
        }
        else
        {
            System.out.println("User " + user + " has no friends.");
        }

    }
}
