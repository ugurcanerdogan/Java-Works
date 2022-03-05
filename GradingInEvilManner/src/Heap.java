
public class Heap {
    /*
        → Comparable interface allows you to use the compareTo() method which is implemented in StudentGrade.java
        → You can easily call the compareTo() method to develop a more flexible code.
        → The compare to function is explained below:
        public int compareTo(Object obj): It is used to compare the current object with the specified object. It returns
            • positive integer, if the current object is greater than the specified object.
            • negative integer, if the current object is less than the specified object.
            • zero, if the current object is equal to the specified object.
    */
    public static void maxHeapify(Comparable[] maxHeap, int n, int i) {
        // TODO: Recursively create a max heap
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        // If left child is larger than root
        if (left < n && maxHeap[left].compareTo(maxHeap[largest]) > 0)
            largest = left;
        // If right child is larger than root
        if (right < n && maxHeap[right].compareTo(maxHeap[largest]) > 0)
            largest = right;
        // If root is not largest
        if (largest != i) {
            // swap a[i] with a[largest]
            Comparable temp = maxHeap[i];
            maxHeap[i] = maxHeap[largest];
            maxHeap[largest] = temp;

            maxHeapify(maxHeap, n, largest);
        }
    }

    public static void minHeapify(Comparable[] minHeap, int n, int i) {
        // TODO: Recursively create a min heap

        int smallest = i; // Initialize smallest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child
        // If left child is smaller than root
        if (left < n && minHeap[left].compareTo(minHeap[smallest]) < 0)
            smallest = left;
        // If right child is smaller than root
        if (right < n && minHeap[right].compareTo(minHeap[smallest]) < 0)
            smallest = right;
        // If root is not smallest
        if (smallest != i) {
            // swap a[i] with a[smallest]
            Comparable temp = minHeap[i];
            minHeap[i] = minHeap[smallest];
            minHeap[smallest] = temp;

            minHeapify(minHeap, n, smallest);
        }
    }
}
