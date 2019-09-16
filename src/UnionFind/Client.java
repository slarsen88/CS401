package UnionFind;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Client
{
    public static void main(String[] args)
    {


        In in = new In("tinyUf.txt");
        int n = in.readInt();
        UnionFind uf = new WeightedQuickUnion(n);
        while (!in.isEmpty())
        {
            int p = in.readInt();
            int q = in.readInt();
            uf.union(p,q);
        }
        System.out.println(uf.getCount());




//        In in = new In("socialnetwork_data.txt");
//        int n = in.readInt();
//        UnionFind uf = new QuickUnion(n);
//        while (!in.isEmpty())
//        {
//            String date = in.readString();
//            int p = in.readInt();
//            int q = in.readInt();
//            uf.union(p,q);
//            if (uf.getCount() == 1)
//            {
//                System.out.println(date);
//                return;
//            }
//        }
    }
}
