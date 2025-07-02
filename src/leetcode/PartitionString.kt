package leetcode


class PartitionString {
        fun partitionString(s: String): List<String> {
            val segments: MutableList<String> = ArrayList()
            var left = 0
            var right = 1
            while (left < right && right <= s.length) {
                val str = s.substring(left, right)
                if (!segments.contains(str)) {
                    segments.add(str)
                    left = right
                    right = left + 1
                } else {
                    right += 1
                }
            }
            return segments
        }
}