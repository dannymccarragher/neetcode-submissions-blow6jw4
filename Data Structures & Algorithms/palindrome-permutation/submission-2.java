class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        for(int value : map.values()){ 
            
            if(value % 2 != 0){
                count++;
            }


        }

        return count <= 1; 
    }
}
