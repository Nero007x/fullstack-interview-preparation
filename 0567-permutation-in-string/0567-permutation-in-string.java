class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()> s2.length()) return false;
        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];

        for(int i = 0; i<s1.length(); i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            freqS1[ch1-'a']++;
            freqS2[ch2-'a']++;
        }

        if(Arrays.equals(freqS1, freqS2)) return true;

        for(int i = s1.length(); i<s2.length(); i++){
            char ch = s2.charAt(i);
            char prevs = s2.charAt(i-s1.length());
            freqS2[ch-'a']++;
            freqS2[prevs-'a']--;

            if(Arrays.equals(freqS1, freqS2)) return true;
        }

        return false;
        
    }
}