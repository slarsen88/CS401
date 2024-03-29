package EdgeWeighted;

public class DirectedEdge
{
    private int v;
    private int w;
    private double weight;

    public DirectedEdge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from()
    {
        return v;
    }

    public int to()
    {
        return w;
    }

    public double weight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return v + " - " + w + " " + weight + " ";
    }

}
