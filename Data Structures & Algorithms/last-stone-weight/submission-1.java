class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> heap = new ArrayList<>();
        for (int stone: stones) {
            heap.add(stone);
            upHeap(heap.size() - 1, heap);
        }
        while (heap.size() > 1) {
            Integer first = removeTop(heap);
            Integer second = removeTop(heap);

            if (first != second) {
                heap.add(Math.abs(first - second));
                upHeap(heap.size() - 1, heap);
            }
        }
        
        return heap.size() == 1 ? heap.get(0) : 0;
    }

    public void upHeap(int index, List<Integer> heap) {
        int parent = (index-1) / 2;
        int max = index;
        if (heap.get(parent) < heap.get(max)) {
            int tmp = heap.get(parent);
            heap.set(parent, heap.get(max));
            heap.set(max, tmp);
            max = parent;
        }

        if (max == index) {
            return;
        }
        upHeap(max, heap);
    }

    public Integer removeTop(List<Integer> heap) {
        if (heap.size() == 1) {
            return heap.remove(0);
        }
        
        Integer tmp = heap.get(0);
        heap.set(0, heap.removeLast());
        downHeap(0, heap);
        
        return tmp;
    }

    public void downHeap(int index, List<Integer> heap) {
        int max = index;
        int left = 2*index + 1;
        int right = 2*index + 2;

        if (left < heap.size() && heap.get(left) > heap.get(max)) {
            max = left;
        }

        if (right < heap.size() && heap.get(right) > heap.get(max)) {
            max = right;
        }

        if (max == index) {
            return;
        }

        Integer tmp = heap.get(max);
        heap.set(max, heap.get(index));
        heap.set(index, tmp);
        downHeap(max, heap);
    }

}
