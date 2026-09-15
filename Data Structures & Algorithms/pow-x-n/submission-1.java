class Solution {
    private double myPowInternal(double x, int n, Map<Integer, Double> valueMap) {
        if (n == 1) return x;
        if (n == -1) return 1/x;
        if (valueMap.keySet().contains(n)) {
            return valueMap.get(n);
        }
        int fh = n/2;
        int sh = n - fh;
        double valueN = myPowInternal(x, fh, valueMap) * myPowInternal(x, sh, valueMap);
        valueMap.put(n, valueN);
        return valueN;
    }

    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1;
        if (x == 0) return 0;
        Map<Integer, Double> valueMap = new HashMap<Integer, Double> ();
        return myPowInternal(x, n, valueMap);
    }
}
