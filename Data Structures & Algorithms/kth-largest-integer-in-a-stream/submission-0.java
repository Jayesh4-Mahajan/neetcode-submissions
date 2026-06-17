class KthLargest {
    // We are implementing a min heap
    // parent should be less than or equal to all of its children
    // with this we only need to maintain a heap of k elements.
    int[] arr;


    public KthLargest(int k, int[] nums) {
        arr = new int[k];
        Arrays.fill(arr, Integer.MIN_VALUE);
        for (int num: nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        if (val > arr[0]) {
            arr[0] = val;
            downHeap(0);
        }

        return arr[0];
    }

    private void downHeap(int parent) {
        if (arr.length <= 1) {
            return;
        } 

        int left = 2*parent + 1;
        int right = 2*parent + 2;
        int min = parent;
        if (left < arr.length && arr[left] < arr[parent]) {
            min = left;
        }
        if (right < arr.length && arr[right] < arr[min]) {
            min = right;
        }

        if (min == parent) {
            return;
        }

        int tmp = arr[min];
        arr[min] = arr[parent];
        arr[parent] = tmp;

        downHeap(min);
    }
}
