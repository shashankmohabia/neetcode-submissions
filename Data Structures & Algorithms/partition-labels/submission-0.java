class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> answer = new ArrayList<>();
        int l = s.length();
        
        int[] lastOccurance = new int[26];
        for (int i = 0;i<l;i++){
            lastOccurance[s.charAt(i)-'a']=i;
        }

        int start = 0;
        int boundary = 0;

        for (int i = 0; i < l; i++) {
            boundary = Math.max(boundary, lastOccurance[s.charAt(i) - 'a']);
            
            if (i == boundary) {
                answer.add(boundary - start + 1);
                start = i + 1; 
            }
        }

        return answer;
    }
}
