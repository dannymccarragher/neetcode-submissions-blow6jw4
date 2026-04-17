class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int i = 0; // track nums1
        int j = 0; // track nums2

        int median1 = 0;
        int median2 = 0;

        // Input: nums1 = [1,2], nums2 = [3] Output: 2.0

        for(int count = 0; count < (n + m) / 2 + 1; count++){

            // copy median2 = median1 to save copy as to not overwrite
            median2 = median1;
            // verify that you can continue comparing values
            // that neither array has been exhaausted

            if(i < n && j < m){
                if(nums1[i] < nums2[j]){
                    median1 = nums1[i];
                    i++;
                } else{
                    median1 = nums2[j];
                    j++;
                }
            } else if(i < n){
                median1 = nums1[i];
                i++;
            } else {
                median1 = nums2[j];
                j++;
            }
        }

        if((n + m) % 2 == 0){
            return (double) (median1 + median2) / 2;
        } else {
            return median1; 
        }

    }
}
