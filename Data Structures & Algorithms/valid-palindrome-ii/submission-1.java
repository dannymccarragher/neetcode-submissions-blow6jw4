class Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while(l < r){

            if(s.charAt(l) != s.charAt(r)){
                return isValid(s, l + 1, r) || isValid(s, l, r - 1);
            }

            l++;
            r--;
        }

        return true;
    }

    private boolean isValid(String s, int l, int r){

        while(l < r){
            if(s.charAt(r) != s.charAt(l)){
                return false;
            }

            l++;
            r--;
        }

        return true; 
    }
}