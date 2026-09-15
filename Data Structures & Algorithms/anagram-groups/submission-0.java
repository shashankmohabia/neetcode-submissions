class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> m = new HashMap<String, List<String>> ();

        for (String s: strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);

            List<String> l = m.getOrDefault(sorted, new ArrayList<String>());
            l.add(s);
            m.put(sorted, l);
        }

        return new ArrayList<>(m.values());
    }
}