class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()){
            return "";
        }

        // create frequency map of t
        Map<Character, Integer> map = new HashMap<>();

        for(char ch : t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int minLength = Integer.MAX_VALUE;
        int count = t.length();
        int start = 0;
        int left = 0;

        // need to track if window is valid
        // traverse s string

        for(int right = 0; right < s.length(); right++){
            char r = s.charAt(right);

            if(map.containsKey(r)){
                map.put(r, map.get(r) - 1);

            if(map.get(r) >= 0){
                count--;
            }
            }

            // all characters within the t hae been found
            while(count == 0){
                int window = right - left + 1;

                if(window < minLength){
                    start = left;
                    minLength = window;
                }

                char l = s.charAt(left);

                if(map.containsKey(l)){
                    map.put(l, map.get(l) + 1);

                    if(map.get(l) > 0){
                        count++;
                    }
                }
            left++;

            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength); 
    }
}
