package Searching;

public class SeparateChainingHashST<Key, Value>
{
    private int n; // number of key-value pairs
    private int m; // hash table size
    private SequentialSearchST<Key, Value>[] st;


    public SeparateChainingHashST(int m)
    {
        st = new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
        {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    int hash(Key key)
    {
        return (key.hashCode() & 0x7fffffff)% m;
    }

    public Value get(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        int h = hash(key);
        return st[h].get(key);
    }

    public void put(Key key, Value value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        if (value == null)
        {
            return; // delete(key)
        }

        // if (n > 10 * m)
        // resize(2*m)

        int h = hash(key);
        st[h].put(key, value);
    }
}
