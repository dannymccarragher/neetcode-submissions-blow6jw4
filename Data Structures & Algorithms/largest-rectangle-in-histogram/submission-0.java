class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;

        Stack<int[]> stack = new Stack<>(); //(index, height)

        for(int i = 0; i < heights.length; i++){
            int start = i;

            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }

            stack.add(new int[]{start, heights[i]});
        }

        for(int[] pair : stack){
            int height = pair[1];
            int index = pair[0];

            maxArea = Math.max(maxArea, height * (heights.length - index ));
        }

        return maxArea;
    }
}