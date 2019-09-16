package UnionFind;

public class QuickUnion implements UnionFind
{
    protected int[] id;
    protected int count;


    public QuickUnion(int n)
    {
        id = new int[n];
        initialize();
        count = n;
    }

    public void initialize()
    {
        for (int i = 0; i < id.length; i++)
        {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q)
    {
        if (find(p,q))
        {
            return;
        }
        int rp = root(p);
        int rq = root(q);
        id[rp] = id[rq];
        count--;
    }

    @Override
    public boolean find(int p, int q)
    {
        int rp = root(p);
        int rq = root(q);
        return rp == rq;
    }

    protected int root(int i)
    {
        while (id[i] != i)
        {
            i = id[i];
        }

        return i;
    }

    @Override
    public int getCount()
    {
        return count;
    }



}
