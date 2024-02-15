public class P1768 {
    public static void main(String[] args) {
        String result = new P1768().mergeAlternately("abc", "xyz");
        System.out.println(result);
    }

    // Accepted Solution 1
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int size = Math.max(word1.length(), word2.length());
        int i=0;
        while(i<size) {
            if(i<word1.length()) sb.append(word1.charAt(i));
            if(i<word2.length()) sb.append(word2.charAt(i));
            i++;
        }
        return sb.toString();
    }
}
