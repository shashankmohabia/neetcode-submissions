class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                st.push(')');
            } else if (c == '{') {
                st.push('}');
            } else if (c == '[') {
                st.push(']');
            } else if (st.isEmpty() || st.pop() != c) {
                // If it's a closing bracket, it MUST match the popped character
                return false;
            }
        }
        
        return st.isEmpty();
    }
}
