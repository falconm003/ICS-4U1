public class ellohay {
    public static void main(String[] args) {
        String word = "hello";
        int vowelIndex = 0;
        for (int ctr = 0; ctr < word.length(); ctr++) {
            String temp = word.substring(ctr, ctr+1);
            if (temp.equals("e")) {
                vowelIndex = ctr;
                break;
            }
        }
        for(int ctr = vowelIndex; ctr < word.length(); ctr++) {
            System.out.print(word.charAt(ctr));
        }
        System.out.print(word.charAt(0) + "ay");
    }
}