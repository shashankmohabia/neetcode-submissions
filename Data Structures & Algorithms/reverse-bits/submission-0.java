class Solution {
    public int reverseBits(int n) {
        int p = 0;
        for(int i=0;i<32;i++){
            p = p<<1;
            p=p|(n&1);
            n = n>>>1;
        }
        return p; 
    }
}
