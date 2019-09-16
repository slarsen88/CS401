package UnionFind;

public class WeightedQuickUnionPathCompression extends WeightedQuickUnion
{
    public WeightedQuickUnionPathCompression(int n)
    {
        super(n);
    }

    @Override
    protected int root(int i)
    {
        while (i != id[i])
        {
            id[i] = id[id[i]];
            i = id[i];
        }

        return i;
    }
}
