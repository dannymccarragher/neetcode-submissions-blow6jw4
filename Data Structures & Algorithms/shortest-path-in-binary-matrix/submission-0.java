
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;

        // can't start or end if blocked
        if (grid[0][0] == 1 || grid[ROWS-1][COLS-1] == 1) return -1;

        // edge case: 1x1 grid
        if (ROWS == 1 && COLS == 1) return 1;

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0});
        visited.add("0,0");

        int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0,-1},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };

        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    String key = newRow + "," + newCol;

                    if (newRow < 0 || newRow >= ROWS ||
                        newCol < 0 || newCol >= COLS ||
                        visited.contains(key) ||
                        grid[newRow][newCol] == 1) continue;

                    if (newRow == ROWS - 1 && newCol == COLS - 1) return length;

                    visited.add(key);
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return -1;
    }
}