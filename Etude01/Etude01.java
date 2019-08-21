import java.util.Scanner;

public class Etude01{

    public static void main(String[]args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String s = scan.nextLine();
            int syllables = 0;
            boolean prevConsonant = true;
            for (int c = 0; c < s.length(); ++c) {
                boolean isConsonant = isConsonant(s.charAt(c));

                if (prevConsonant && !isConsonant) {
                    syllables++;
                }

                prevConsonant = isConsonant;
            }
            if (s.length() > 1 && syllables > 1  && s.charAt(s.length() - 1) == 'e' && isConsonant(s.charAt(s.length() - 2))) {
                syllables--;
            }
            
            System.out.print(s + ": ");
            System.out.println(syllables);
        }    
    }

    public static boolean isVowel(char c) {
        final String vowels = "aeiouy";
        return vowels.indexOf(c) > -1; 
    }

    public static boolean isConsonant(char c) {
        if (c == 'y') {
            return true;
        }
        return !isVowel(c);
    }
}
