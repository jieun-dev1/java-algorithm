package leetcode;

//우선 일치하는 첫글자 찾아야 함. 하지만 다음글자가 일치하지 않으면, 그냥 다시 뱉어야 함..
//그리고 다른 첫글자를 처음부터 찾아야 해 (하지만 visited 배열 초기화)
//시작점에서 할 수 있는 모든 탐색을 백트래킹으로 하기
//내가 갈수 있는 방향은 정해져 있음. DFS. BFS 로 하면, 중복 체크가 귀찮아짐.

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (find(board, word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    public boolean find(char[][] board, String word, int x, int y, int index) {
        if (x >= board.length || y >= board[0].length || x < 0 || y < 0) {
            return false;
        }

        if (board[x][y]!= word.charAt(index)) {
            return false;
        }

        if (index == word.length() -1) {
            return true;
        }
        //재방문 하지 않도록,
        board[x][y] = '_';
        if (find(board, word, x-1, y, index + 1)) return true;
        if (find(board, word, x, y-1, index + 1)) return true;
        if (find(board, word, x+1, y, index + 1)) return true;
        if (find(board, word, x, y+1, index + 1)) return true;
        board[x][y] = word.charAt(index);
        return false;
    }
}
