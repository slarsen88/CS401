package Searching;

public class SearchManager
{
    // Nonrecursive binary search algorithm
//    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
//    {
//        while (left <= right)
//        {
//            int mid = (left + right) / 2;
//            int compare = key.compareTo(a[mid]);
//            if (compare == 0)
//            {
//                return mid;
//            }
//            else if (compare < 0)
//            {
//                right = mid - 1;
//            }
//            else
//            {
//                left = mid + 1;
//            }
//        }
//
//        return -1;
//    }


    // Recursive binary search algorithm
    public static int binarySearch(Comparable[] a, Comparable key, int left, int right)
    {
        if (left <= right)
        {
            int mid = (left + right) / 2;
            int compare = key.compareTo(a[mid]);
            if (compare == 0)
            {
                return mid;
            }
            else if (compare < 0)
            {
                binarySearch(a, key, left, mid - 1);
            }
            else
            {
                binarySearch(a, key, mid + 1, right);
            }
        }

        return -1;
    }

}
