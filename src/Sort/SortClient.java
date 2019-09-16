package Sort;

public class SortClient
{
    public static void main(String[] args)
    {
        Comparable[] a = {23, 78, 45, 8, 32, 56};
        //Sort.selectionSort(a);
        //Sort.quickSort(a, 0, 5);
        Sort.bubbleSort(a);
        for (Comparable s : a)
        {
            System.out.print(s + " ");
        }
    }
}
