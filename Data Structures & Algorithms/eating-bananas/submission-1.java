class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        // h represents number of hours to eat all the bananas
        // k represents number of bananas eaten per hour

        int r = Integer.MIN_VALUE;
    
        for(int p : piles){
            if(p >= r){
                r = p;
            }
        }

        int result = r;
        int l = 1;

        while(l <= r){
            int k = l + (r - l) / 2;

            long totalTime = 0;

            for(int p : piles){

                totalTime += Math.ceil((double) p / k);
            }

            if(totalTime <= h){
                r = k - 1;
                result = k;
            }else{
                l = k + 1;
            }
        }

        return result; 


        
    }
}