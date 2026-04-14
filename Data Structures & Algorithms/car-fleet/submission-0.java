class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Integer[] indices = new Integer[n];

        for(int i = 0; i < n; i++){
            indices[i] = i;
        }

        Arrays.sort(indices, (i, j) -> position[j] - position[i]);

        int res = 0;
        double prev = 0;

        for(int index : indices){

            double currArrivalTime = (double) (target - position[index]) / speed[index];

            if(currArrivalTime > prev){
                res++;
                prev = currArrivalTime;
            }
        }

        return res; 
    }
}