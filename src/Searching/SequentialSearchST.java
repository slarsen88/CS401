package Searching;
import javax.xml.soap.Node;

public class SequentialSearchST<Key, Value>
{
    private Node first; // first node in the linked list


    private class Node
    {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next)
        {
            this.key = key;
            this.value = value;
            this.next = next;
        }


    }

    public Value get(Key key)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
            {
                return x.value;
            }
        }

        return null;
    }

    public void put(Key key, Value value)
    {
        for (Node x = first; x != null; x = x.next)
        {
            if (key.equals(x.key))
            {
                x.value = value;
                return;
            }
        }

        first = new Node(key, value, first);
    }
}
