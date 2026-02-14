Below is an English translation of the notes:

When analyzing only the inner while (excluding the outer for loop):

- Starting from both ends (left = i + 1, right = n - 1):
  left only increases and right only decreases, so each pointer moves at most n times, giving O(n) for the inner loop.
  (They never "chase" each other; movement is strictly one direction.)
- Starting with right = left + 1:
  To adjust the sum, right must be pushed far, and every time left changes, right needs to move a lot again.
  So even the inner part tends toward O(n^2)-level movement.

Therefore, looking only at the inner loop:

- Both-ends start: O(n)
- right = left + 1: near O(n^2) of unnecessary movement

Notes on sorting:

Arrays.sort for int[] uses Dual-Pivot Quicksort, with average/worst-case O(n log n).
Overall time complexity is O(n^2), and including sorting it becomes O(n log n + n^2) = O(n^2).
