class Solution {
    public int shortestPath(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        if (grid[0][0] != 0) {
            return -1;
        }

        return bfs(grid, 0, 0, visited);
    }

    private static int bfs(int[][] grid, int row, int col, boolean[][] visited) {

        Queue<int[]> q = new ArrayDeque<>();

        q.add(new int[]{row, col});
        visited[row][col] = true;
        int count = 0;

        int[][] directions = new int[][]{
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int currRow = curr[0];
                int currCol = curr[1];

                if (currRow == grid.length - 1 && currCol == grid[0].length - 1) {
                    return count;
                }

                for (int[] dir : directions) {
                    int newR = currRow + dir[0];
                    int newC = currCol + dir[1];

                    if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length
                            && !visited[newR][newC] && grid[newR][newC] != 1) {
                        visited[newR][newC] = true;
                        q.add(new int[]{newR, newC});
                    }
                }
            }
            count++;
        }
        return -1;
    }
}