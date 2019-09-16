/*
        Author: Stuart Larsen
        Date: 6/19/2019
        Course: Algorithms Winter 2019
        Assignment: 4
        Instructor: Fatma Serce
        Synopsis: This is the main driver for the RecommenderSystem program. It creates a RecommenderSystem object
                  and runs all the methods implemented from the interface
 */

package Assignment4;

public class Client
{

    public static void main(String[] args)
    {
        RecommenderSystem recommenderSystem = new RecommenderSystem();
//        recommenderSystem.listFriends(1283);
//        recommenderSystem.commonFriends(31, 4);
//        recommenderSystem.listArtists(2, 4);
//        recommenderSystem.listTop10();
        recommenderSystem.recommend10(1283);
    }
}
