package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class SmallestInfiniteSet {

    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> removed = new HashSet<>();

    public SmallestInfiniteSet() {
        for (int i=1; i<=1000; i++) {
            pq.add(i);
        }
    }

    public int popSmallest() {
        int element = pq.peek();
        removed.add(element);
        return pq.poll();
    }

    public void addBack(int num) {
        if (removed.contains(num)) {
            removed.remove(num);
            pq.add(num);
        }
    }
}
