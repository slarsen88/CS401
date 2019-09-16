package Sort;


public class Sort
{
    public static void selectionSort(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            int min = i;
            for (int j = i; j < a.length; j++)
            {
                if (less(a[j], a[min]))
                {
                    min = j;
                }
            }

            swap(a, min, i);
        }
    }


    private static void swap(Comparable[] a, int min, int i)
    {
        Comparable temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }


    public static void insertionSort(Comparable[] a)
    {
        for (int i = 1; i < a.length; i++)
        {
            for (int j = i; (j > 0 && less(a[j], a[j - 1])); j--)
            {
                {
                    swap(a, j,j-1);
                }
            }
        }
    }

    private static boolean less(Comparable o1, Comparable o2)
    {

        return o1.compareTo(o2) < 0;
    }

    public static void bubbleSort(Comparable[] a)
    {
        for (int i = 0; i < a.length; i++)
        {
            for (int j = a.length-1; j > i; j--)
            {
                if (less(a[j], a[j-1]))
                {
                    swap(a, j-1, j);
                }
            }
        }
    }

    public static void mergeSort(Comparable[] a, int first, int last)
    {
        if (first < last)
        {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid);
            mergeSort(a, mid + 1, last);
            merge(a, first, mid, last);
        }
    }

    private static void merge(Comparable[] a, int first, int mid, int last)
    {
        Comparable[] temp = new Comparable[a.length];
        int first1 = first;
        int last1 = mid;
        int first2 = mid + 1;
        int last2 = last;
        int index = first;
        for (;(first1 <= last1 && first2 <= last2); index++)
        {
            if (less(a[first1], a[first2])) //
            {
                temp[index] = a[first1];
                first1++;
            }
            else
            {
                temp[index] = a[first2];
                first2++;
            }
        }

        for(; first1 <= last1; index++)
        {
            temp[index] = a[first1];
            first1++;
        }

        for (; first2 <= last2; index++)
        {
            temp[index] = a[first2];
            first2++;
        }

        // Copy sorted array into original array
        for (int i = first; i <=  last; i++)
        {
            a[i] = temp[i];
        }
    }

    public static void quickSort(Comparable[] a, int first, int last)
    {
        if (first < last)
        {
            int pivotIndex = partition(a, first, last);
            quickSort(a, first, pivotIndex - 1); // quicksort the left (s1) of pivot
            quickSort(a, pivotIndex + 1, last); // quicksort the right (s2) of pivot
        }
    }

    private static int partition(Comparable[] a, int first, int last)
    {
        choosePivot(a, first, last); // choose a pivot and place it into the first element of the array
        int pivotIndex = first;
        Comparable pivot = a[first];
        int lastS1 = pivotIndex;
        int firstUknown = pivotIndex + 1;
        for (; firstUknown <= last; firstUknown++)
        {
            if (less(a[firstUknown], pivot))
            {
                lastS1++;
                swap(a, firstUknown, lastS1);
            }
        }

        swap(a, pivotIndex, lastS1);
        pivotIndex = lastS1;
        return pivotIndex;
    }

    private static void choosePivot(Comparable[] a, int first, int last)
    {
        // assume pivot will be first element
    }

    public static void shellSort(Comparable[] a)
    {
        int n = a.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1;

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    swap(a, j, j-h);
                }
            }
            h /= 3;
        }
    }

    public static void heapSort(Comparable[] a)
    {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--)
        {
            heapify(a, n, i);
        }
        for (int i = n - 1; i >= 0; i--)
        {
            Comparable temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            heapify(a, i, 0);
        }
    }

    private static void heapify(Comparable[] a, int n, int i)
    {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && less(a[largest], a [1]))
        {
            largest = l;
        }

        if (r < n && less(a[largest], a [r]))
        {
            largest = r;
        }

        if (largest != i)
        {
            Comparable swap = a [i];
            a[i] =a[largest];
            a[largest] = swap;

            heapify(a, n, largest);
        }
    }
}
