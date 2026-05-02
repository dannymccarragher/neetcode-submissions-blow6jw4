class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] output = new int[n - k + 1];

        for(int i = 0; i <= n - k; i++){
            int maxI = nums[i];
            for(int j = i; j < i + k; j++){
                maxI = Math.max(maxI, nums[j]);
            }

            output[i] = maxI;

        }


        return output; 
        
    }
}
