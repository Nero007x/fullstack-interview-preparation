class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, currentVowels = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        // Initialize first window
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
        }

        maxVowels = currentVowels;

        // Slide the window
        for (int i = k; i < s.length(); i++) {
            if (vowels.contains(s.charAt(i))) {
                currentVowels++;
            }
            if (vowels.contains(s.charAt(i - k))) {
                currentVowels--;
            }
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }
}
