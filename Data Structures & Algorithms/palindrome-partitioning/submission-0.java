class Solution {
    private boolean isP(String s, int l, int r) {
        while (l<r){
            if(s.charAt(l) != s.charAt(r))return false;
            l++;
            r--;
        }
        return true;
    }

    private void getList(List<List<String>> a, String s, int start, List<String> current) {
        if(start == s.length()) {
            a.add(new ArrayList<>(current));
            return;
        } 

        for(int i = start;i<s.length();i++){
            if(isP(s, start, i)){
                current.add(s.substring(start, i + 1));
                getList(a, s, i+1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        
        List<List<String>> answer = new ArrayList<>();
        getList(answer, s, 0, new ArrayList<>());
        return answer;
    }
}
