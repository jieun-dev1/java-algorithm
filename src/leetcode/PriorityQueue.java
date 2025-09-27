package leetcode;

import java.util.*;

class SmallestInfiniteSet {
    private int smallest = 1;  // 현재 가장 작은 연속된 수
    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {
        // 무한집합은 개념적으로 존재, smallest로 추적
    }

    public int popSmallest() {
        //if it exists in pq, it means it was added back. hence, should remove from set.
        if (!pq.isEmpty()) {
            int result = pq.poll();
            set.remove(result);
            return result;
        }
        return smallest++; //return and increase
    }

    //addBack: number does not exist in a queue, and addedBack manually.

    public void addBack(int num) {
        if (num < smallest && !set.contains(num)) {
            pq.offer(num);
            set.add(num);
        }
        // wrong approach - I think I got confused when I initiated the range of nums and delete them.

        // if (num < smallest && set.contains(num)) {
        //     addedBackPq.offer(num);
        //     set.remove(num);
        // }
    }
}