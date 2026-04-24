class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;

        boolean[][] visited = new boolean[ROWS][COLS];

        for(int row = 0; row < ROWS; row++){
            for(int col = 0; col < COLS; col++){
                if(dfs(board, row, col, visited, word, 0)){
                    return true;
                }
            }
        }
        return false; 
    }

    public boolean dfs(char[][] board, int row, int col, boolean[][] visited, String word, int i){

        if(i == word.length()){
            return true;
        }

        int rows = board.length;
        int cols = board[0].length;
        // verify that we are at an appropriate location
        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || board[row][col] != word.charAt(i) ){
            return false; 
        }

        // set current location to visited
        visited[row][col] = true;

        int[][] directions = new int[][]{
            {1,0},
            {-1,0},
            {0, 1},
            {0, -1}
        };

        for(int[] dir : directions){
            if(dfs(board, row + dir[0], col + dir[1], visited, word, i + 1)){
                return true;
            }
 
        }

        visited[row][col] = false;

        return false; 
    }
}
