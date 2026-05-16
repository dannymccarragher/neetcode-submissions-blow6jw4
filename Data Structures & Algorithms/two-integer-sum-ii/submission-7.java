class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // return of indices is 1-indexed
        // index1 < index2

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = numbers.length - 1; i >= 0 ; i--){
            // calculate the correct missing number that is needed to get the target
            int comp = target - numbers[i];

            if(map.containsKey(comp)){
                return new int[]{i + 1, map.get(comp) + 1};
            } else {
                map.put(numbers[i], i);
            }
        }

        return new int[]{-1, -1}; 
    }
}
