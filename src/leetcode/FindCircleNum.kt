package leetcode

class FindCircleNum {
        fun findCircleNum(isConnected: Array<IntArray>): Int {
            val n = isConnected.size
            val m = isConnected[0].size
            val visited = BooleanArray(n)
            var count = 0
            for (i in 0 until n) {
                if (!visited[i]) {
                    dfs(i, isConnected, visited)
                    count += 1
                }
            }
            return count
        }

        //I put i+1 here first. but, when [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]] it cannot traverse in the reverse direction.
        fun dfs(i: Int, isConnected: Array<IntArray>, visited: BooleanArray) {
            visited[i] = true
            for (j in isConnected.indices) {
                if (isConnected[i][j] == 1 && !visited[j]) {
                    dfs(j, isConnected, visited)
                }
            }
        }
    }