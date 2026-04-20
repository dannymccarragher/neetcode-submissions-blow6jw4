class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;

        // create feq map for s1 which we will use to compare to s2 map
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);
        }

        int matches = 0;
        int need = s1Map.size();

        int left = 0;

        for (int right = 0; right < s2.length(); right++) {
            // add current character to s2Map

            char r = s2.charAt(right);
            s2Map.put(r, s2Map.getOrDefault(r, 0) + 1);

            if (s1Map.containsKey(r)) {
                if (s2Map.get(r).equals(s1Map.get(r))) {
                    matches++;
                } else if (s2Map.get(r).equals(s1Map.get(r) + 1)) {
                    matches--;
                }
            }

            // invalid window found.

            if (right - left + 1 > s1.length()) {
                char l = s2.charAt(left);
                if (s1Map.containsKey(l)) {
                    if (s2Map.get(l).equals(s1Map.get(l))) {
                        matches--;
                    } else if (s2Map.get(l).equals(s1Map.get(l) + 1)) {
                        matches++;
                    }
                }
                s2Map.put(l, s2Map.get(l) - 1);
                left++;
            }

            if (matches == need) {
                return true;
            }
        }

        return false;
    }
}