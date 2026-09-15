class Solution {
    public boolean isPalindrome(String s) {
        int l = s.length();
        int i = 0;
        int j = l-1;
        while(i<=j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            //System.out.println("testing i = " + ci + ", j = " + cj);
            if (!('a' <= ci && ci <= 'z') && !('A' <= ci && ci <= 'Z') && !('0' <= ci && ci <= '9')) {
                i++;
                continue;
            }
            if (!('a' <= cj && cj <= 'z') && !('A' <= cj && cj <= 'Z') && !('0' <= cj && cj <= '9')){
                j--;
                continue;
            }
            if(Character.toLowerCase(ci) != Character.toLowerCase(cj)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
