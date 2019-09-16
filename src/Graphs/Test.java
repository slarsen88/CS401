package Graphs;

import edu.princeton.cs.algs4.In;

public class Test
{
    public static void main(String[] args)
    {

        DirectedGraph diGraph = new DirectedGraph(5);
        diGraph.addEdge(0,1);
        diGraph.addEdge(1,2);
        diGraph.addEdge(3,2);
        diGraph.addEdge(3,4);


        DirectedCycle dc = new DirectedCycle(diGraph);
        if (!dc.hasCycle())
        {
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(diGraph);
            System.out.println(depthFirstOrder.reversePostOrder());
        }
        else
        {
            System.out.println("No topological order");
        }













//        In in = new In("tinyG.txt");
//        int vertices = in.readInt();
//        int edges = in.readInt();
//        Graph graph = new Graph(vertices);
//        //DirectedGraph g = new DirectedGraph(vertices);
//        for (int i = 0; i < edges; i++)
//        {
//            int v = in.readInt();
//            int w = in.readInt();
//            graph.addEdge(v, w);
//        }
//
//        System.out.println(graph);

//        DirectedCycle dc = new DirectedCycle(g);
//        if (dc.hasCycle())
//        {
//            System.out.println(dc.cycle());
//        }
//        else
//        {
//            System.out.println("No cycle found");
//        }



//        Graph graph = new Graph(vertices);
//        for (int i = 0; i < edges; i++)
//        {
//            int v = in.readInt();
//            int w = in.readInt();
//            graph.addEdge(v, w);
//        }

//        GraphMatrix graph = new GraphMatrix(4);
//        graph.addEdge(0, 1);
//        graph.addEdge(0, 2);
//        graph.addEdge(1, 3);
//        System.out.println(graph.degree(3));
//        for (int x : graph.adj(1))
//        {
//            System.out.println(x);
//        }

//        DepthFirstSearch dfs = new DepthFirstSearch(graph, 0);
//        System.out.println(dfs.hasPath(6));
//        System.out.println(dfs.pathTo(6));
//
//        System.out.println(graph);
//
//
//        BreadthFirstSearch bfs = new BreadthFirstSearch(graph, 0);
//        if (dfs.hasPath(6))
//        {
//            System.out.println(dfs.pathTo(6));
//        }


    }
}
