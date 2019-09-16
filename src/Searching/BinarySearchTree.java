package Searching;

public class BinarySearchTree<Key extends Comparable<Key>, Value>
{
    private class Node
    {
        Key key;
        Value value;
        Node left;
        Node right;
        int size;

        public Node(Key key, Value value, BinarySearchTree<Key, Value>.Node left, BinarySearchTree<Key, Value>.Node right)
        {
            super();
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    public boolean isEmpty()
    {
        return size() == 0;
    }

    private int size()
    {
        return size(root);
    }

    private int size(Node x)
    {
        if (x == null)
        {
            return 0;
        }

        return x.size;
    }

    public boolean contains(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        return get(key) != null;
    }

    public Value get(Key key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        return get(root, key);
    }

    private Value get(Node x, Key key)
    {
        if (x == null)
        {
            return null; // key does not exist
        }

        int compare = key.compareTo(x.key);
        if (compare == 0)
        {
            return x.value;
        }
        else if (compare < 0)
        {
            return get(x.left, key);
        }
        else
        {
            return get(x.right, key);
        }

    }

    public void put(Key key, Value value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }

        if (value == null)
        {
           // delete(null);
        }
    }



    public static void main(String[] args)
    {
        BinarySearchTree<String, Integer> bst = new BinarySearchTree<>();
    }
}
