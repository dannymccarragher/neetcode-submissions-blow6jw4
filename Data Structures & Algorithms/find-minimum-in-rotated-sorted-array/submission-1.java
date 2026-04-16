class Solution {
    public int findMin(int[] nums) {
        // calculate middle.
        // find the minimal value between the left and right pointers.
        // if the right value is greater than left value, the minimum must be
        // in the right side of the array, otherwise it will be in the left

        // Input: nums = [3,4,5,6,1,2]

        int min = Integer.MAX_VALUE; 

        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left) / 2; 

            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        if(nums[mid] < min){
            min = nums[mid];
        }
        }

        return min; 
    }
}
