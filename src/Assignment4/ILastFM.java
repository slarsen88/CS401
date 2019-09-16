/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This interface defines all the methods proposed by the project. Implemented by RecommenderSystem class

 */
package Assignment4;

public interface ILastFM
{
    void listFriends(int user);
    void commonFriends(int user1, int user2);
    void listArtists(int user1, int user2);
    void listTop10();
    void recommend10(int user);
}
