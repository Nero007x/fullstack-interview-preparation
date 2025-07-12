class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxF = 0;
        int maxL= 0;
        int l = 0;

        for(int r = 0; r<s.length(); r++){
            char rightChar = s.charAt(r);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0)+1);
            maxF = Math.max(maxF, freqMap.get(rightChar));

            while((r-l+1-maxF) > k){
                char leftChar = s.charAt(l);
                freqMap.put(leftChar, freqMap.get(leftChar)-1);
                l++;
            }

            maxL = Math.max(maxL, r-l+1);
        }

        return maxL;
    }
}