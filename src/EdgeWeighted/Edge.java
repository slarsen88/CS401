package EdgeWeighted;

public class Edge implements Comparable<Edge>
{
    private int v;
    private int w;
    private double weight;

    public Edge(int v, int w, double weight)
    {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either()
    {
        return v;
    }

    public int other(int vertex)
    {
        if (vertex == this.v)
        {
            return w;
        }
        else if (vertex == this.w)
        {
            return v;
        }
        else
        {
            throw new IllegalArgumentException();
        }
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

    @Override
    public int compareTo(Edge other)
    {
        return Double.compare(weight, other.weight);
    }
}
