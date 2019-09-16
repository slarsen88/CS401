package UnionFind;

public class QuickFind implements UnionFind
{
    private int[] id;
    private int count;

    public QuickFind(int n)
    {
        count = n;
        id =  new int[n];
        initialize(n);
    }

    public void initialize(int n)
    {
        for (int i = 0; i < n; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q)
    {
        int pId = id[p];
        int qId = id[q];
        if (!(find(p,q)))
        {
            for (int i = 0; i < id.length; i++)
            {
                if (id[i] == pId)
                {
                    id[i] = qId;
                }
            }
            count--;
        }
    }

    @Override
    public boolean find(int p, int q)
    {
        return id[p] == id[q];
    }

    @Override
    public int getCount()
    {
        return count;
    }



    // *******************************
    // IN CLASS IMPLEMENTATION BELOW

//    public QuickFind(int n)
//    {
//        id = new int[n];
//        initialize();
//        count = n;
//    }
//
//    public void initialize()
//    {
//        for (int i = 0; i < id.length; i++)
//        {
//            id[i] = i;
//        }
//    }
//
//    @Override
//    public void union(int p, int q)
//    {
//        if (find(p,q))
//        {
//            return;
//        }
//
//        int pId = id[p];
//        int qId = id[q];
//        for (int i = 0; i < id.length; i++)
//        {
//            if (id[i] == pId)
//            {
//                id[i] = qId;
//            }
//        }
//
//        count--;
//    }
//
//    @Override
//    public boolean find(int p, int q)
//    {
//        return id[p] == id[q];
//    }
//
//    @Override
//    public int getCount()
//    {
//        return count;
//    }
}
