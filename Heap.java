/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

public class Heap {
    public static void sort(Comparable[] a) {
        int N = a.length;
        setHeap(a, N);
        // positioningMax(a, N); un-needed abstraction
        while (N > 1) {
            exch(1, N--, a);
            sink(1, N, a);
        }
        for (Comparable item : a)
            System.out.println(item);

    }

    private static void setHeap(Comparable[] a, int N) {
        int nodeNo = N / 2;
        while (nodeNo > 0) {
            sink(nodeNo, N, a);
            nodeNo--;
        }
    }

    private static void swim(int k, Comparable[] heap) {
        while (k > 1) {
            int parent = k / 2;
            if (less(k, parent, heap)) break;
            exch(k, parent, heap);
            k = parent;
        }
    }

    private static void exch(int i, int j, Comparable[] heap) {
        i--;
        j--;
        Comparable temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private static boolean less(int i, int j, Comparable[] heap) {
        i--;
        j--;
        return heap[i].compareTo(heap[j]) < 0;
    }


    private static void sink(int k, int N, Comparable[] heap) {
        while (2 * k <= N) {
            int child = 2 * k;
            if (child < N && less(child, child + 1, heap)) child += 1;
            if (less(child, k, heap)) break;
            exch(k, child, heap);
            k = child;
        }

    }

    public static void main(String[] args) {
        Heap.sort(new Integer[] { 1, 2, 3, 4, 5, 6, 7 });
    }
}
