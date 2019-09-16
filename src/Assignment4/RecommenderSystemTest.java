/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This program has a few test cases for each of the methods in the RecommenderSystem class
 */

package Assignment4;

import static org.junit.jupiter.api.Assertions.*;

import edu.princeton.cs.algs4.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RecommenderSystemTest
{
    static Digraph userFriendsGraph;
    static EdgeWeightedDigraph userArtistGraph;
    static HashMap<Integer, Artist> artistMap;
    RecommenderSystem recommenderSystem = new RecommenderSystem();

    // Test to ensure that graphs are created before each test is run (and that graphs are not null)
    @BeforeEach
    public void shouldCreateGraphs()
    {
        UserArtistRelations relations = new UserArtistRelations();
        userFriendsGraph = relations.createUserFriendsGraph();
        userArtistGraph = relations.createUserArtistGraph();
        assertTrue(userArtistGraph != null && userFriendsGraph != null);
    }

    // Test to ensure that the artist map is created, filled, and not null
    @BeforeEach
    public void shouldCreateArtistMap()
    {
        artistMap = new HashMap<>();
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

        assertTrue(artistMap != null);
    }


    // Checks that it's possible to create a RecommenderSystem object and not be null
    @Test
    public void shouldCreateRecommenderSystemObject()
    {
        recommenderSystem = new RecommenderSystem();
        assertTrue(recommenderSystem != null);
    }

    // Checks that it's possible to create an Artist object and have it not be null
    @Test
    public void shouldCreateArtistObject()
    {
        Artist artist = new Artist();
        assertTrue(artist != null);
    }

    // Checks that, given a parameter, the proper friends list is returned
    @Test
    public void shouldListFriends()
    {
        // should return: 1956, 831, 743
        Iterable<Integer> friendsResult = userFriendsGraph.adj(9);
        List friendsResultList = new ArrayList();
        for (int x : userFriendsGraph.adj(9))
        {
            friendsResultList.add(x);
        }

        List testList = new ArrayList();
        testList.add(1956);
        testList.add(831);
        testList.add(743);

        assertEquals(friendsResultList, testList);

    }

    // checks to see if, given an invalid userID, the program handles it
    @Test
    public void shouldTestInvalidUserInput()
    {
        Iterable<Integer> emptyFriendsResult = userFriendsGraph.adj(19);
        assertFalse(emptyFriendsResult.iterator().hasNext());
    }

    // Checks to see if the correct common friends list is returned, given 2 users
    @Test
    public void shouldListCommonFriends()
    {
        // both lists should contain: 831
        List commonsFriendsResultList = new ArrayList();
        for (int friendsOfUser1 : userFriendsGraph.adj(2))
        {
            for (int friendsOfUser2 : userFriendsGraph.adj(5))
            {
                if (friendsOfUser1 == friendsOfUser2)
                {
                    commonsFriendsResultList.add(friendsOfUser1);
                }
            }
        }

        List testFriendsResultList = new ArrayList();
        testFriendsResultList.add(831);
        assertEquals(commonsFriendsResultList, testFriendsResultList);
    }


    // Checks to see if, given two users, the correct common Artist list is returned
    @Test
    public void shouldListCommonArtists()
    {
        Artist artist;
        String name;
        List<String> commonArtistList = new ArrayList<>();
        for (DirectedEdge artistUser1 : userArtistGraph.adj(2))
        {
            for (DirectedEdge artistUser2 : userArtistGraph.adj(4))
            {
                if (artistUser1.to() == artistUser2.to())
                {

                    artist = artistMap.get(artistUser1.to());
                    name = artist.getName();
                    commonArtistList.add(name);
                }
            }
        }

        List<String> testList = new ArrayList<>();
        testList.add("George Michael");
        testList.add("Depeche Mode");
        testList.add("Moby");
        testList.add("Coldplay");
        testList.add("Röyksopp");
        testList.add("Air");
        testList.add("Duran Duran");

        assertEquals(commonArtistList, testList);
    }

    // Checks to see if the correct top 10 artists are returned
    @Test
    public void shouldListTop10()
    {
        Artist artist;
        // iterate over the adjacency lists. If the artist is in the map, update the listencount
        for (int i = 0; i < userFriendsGraph.V(); i++)
        {
            for (DirectedEdge edge : userArtistGraph.adj(i))
            {
                if (artistMap.containsKey(edge.to()))
                {
                    artist = artistMap.get(edge.to());
                    artist.setListeningCount(artist.getListeningCount() + edge.weight());
                    artistMap.put(edge.to(), artist);
                }
            }
        }

        // Loop over hash map and add values to minPQ
        MinPQ<Artist> pq = new MinPQ<>();
        for (int i = 1; i < artistMap.size(); i++)
        {
            if (artistMap.get(i) != null)
            {
                if (i <= 10)
                {
                    pq.insert(artistMap.get(i));
                }
                else if (artistMap.get(i).getListeningCount() > pq.min().getListeningCount())
                {
                    pq.delMin();
                    pq.insert(artistMap.get(i));
                }
            }
        }

        Stack<Artist> top10Artists = new Stack<>();
        for (int i = 0; i < 10; i++)
        {
            top10Artists.push(pq.delMin());
        }

        List<String> top10ArtistList = new ArrayList<>();
        for (Artist artistInStack : top10Artists)
        {
            top10ArtistList.add(artistInStack.getName());
        }

        List<String> top10TestList = new ArrayList<>();
        top10TestList.add("Britney Spears");
        top10TestList.add("Depeche Mode");
        top10TestList.add("Lady Gaga");
        top10TestList.add("Christina Aguilera");
        top10TestList.add("Paramore");
        top10TestList.add("Madonna");
        top10TestList.add("Rihanna");
        top10TestList.add("Shakira");
        top10TestList.add("The Beatles");
        top10TestList.add("Katy Perry");

        assertEquals(top10ArtistList, top10TestList);
    }

    // Checks to see that, given a user, the correct recommended 10 artists are returned
    @Test
    public void shouldListRecommended10()
    {
        HashMap<Integer, Artist> recommendedArtists = new HashMap<>();
        MinPQ<Artist> pq = new MinPQ<>();
        for (DirectedEdge edge : userArtistGraph.adj(4))
        {
            Artist artist = new Artist();
            addArtistToRecommendedList(recommendedArtists, edge, artist);
        }

        // Iterate over friends list and do the same logic as above
        for (int v : userFriendsGraph.adj(4))
        {
            for (DirectedEdge edge: userArtistGraph.adj(v))
            {
                Artist artist = new Artist();
                if (!recommendedArtists.containsKey(edge.to()))
                {
                    addArtistToRecommendedList(recommendedArtists, edge, artist);
                }
                else if (recommendedArtists.get(edge.to()).getListeningCount() < edge.weight())
                {
                    addArtistToRecommendedList(recommendedArtists, edge, artist);
                }
            }
        }

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

        Stack<Artist> top10Artists = new Stack<>();
        for (int j = 0; j < 10; j++)
        {
            top10Artists.push(pq.delMin());
        }

        List<String> recommend10List = new ArrayList();
        for (Artist artist: top10Artists)
        {
            recommend10List.add(artist.getName());
        }

        List<String> recommend10TestList = new ArrayList();
        recommend10TestList.add("Depeche Mode");
        recommend10TestList.add("Marc Almond");
        recommend10TestList.add("And One");
        recommend10TestList.add("Soft Cell");
        recommend10TestList.add("Dave Gahan");
        recommend10TestList.add("Pet Shop Boys");
        recommend10TestList.add("Paul Anka");
        recommend10TestList.add("Portishead");
        recommend10TestList.add("Paradise Lost");
        recommend10TestList.add("Erasure");

        assertEquals(recommend10List, recommend10TestList);
    }

    // Helper method for the above test
    private void addArtistToRecommendedList(HashMap<Integer, Artist> recommendedArtists, DirectedEdge edge, Artist artist)
    {
        artist.setId(edge.to());
        artist.setName(artistMap.get(edge.to()).getName());
        artist.setListeningCount(edge.weight());
        recommendedArtists.put(edge.to(), artist);
    }
}