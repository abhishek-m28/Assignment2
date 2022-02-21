package amohabe.asu.edu;

import java.util.ArrayList;

public class Caesar {

    private static final char CHARA = 'a';
    private static final char CHARZ = 'z';
    private static final int LETTERSIZE = 26;

    public static String cipher(String input, int offset) {
        char[] ch = input.toCharArray();
        offset %= LETTERSIZE;
        shiftBy(ch, offset);
        return new String(ch);
    }

    private static void shiftBy(char[] ch, int offset) {
        for (int i = 0; i < ch.length; ++i) {
            if (ch[i] != ' ') {
                ch[i] = offsetChar(ch[i], offset, CHARA, CHARZ);
            }
        }
    }

    private static char offsetChar(char ch, int offset, char A, char Z) {
        ch += offset;
        if (ch < A) {
            return (char) (ch + LETTERSIZE);
        }
        if (ch > Z) {
            return (char) (ch - LETTERSIZE);
        }
        return ch;
    }

    public static String decrypt(String input, int offset) {

        return "a";
    }

    public static void main(String[] args) {

    }

}
