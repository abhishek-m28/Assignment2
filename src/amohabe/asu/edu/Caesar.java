package amohabe.asu.edu;

import java.util.Scanner;

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

        String letters = "abcdefghijklmnopqrstuvwxyz";
        char rVal;
        String result = "";
        int cPos, value;

        for(int i = 0; i < input.length(); i++){
            switch(input.charAt(i)){

                case '!': result += "!";
                    break;
                case '?': result += "?";
                    break;
                case ' ': result += ' ';
                    break;
                case '.': result += '.';
                    break;
                case ',': result += ",";
                    break;

                default: cPos = letters.indexOf(input.charAt(i));
                    value = (cPos - offset) % 26;

                    if(value < 0){
                        value = letters.length() + value;
                    }

                    rVal = letters.charAt(value);
                    result += rVal;
                    break;
            }
        }
        return result;
    }

    public static int menu() {

        int i = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("\nChoose the option:");
        System.out.println("1: Encrypt");
        System.out.println("2: Decrypt");
        System.out.println("3: Quit\n");
        System.out.println("Your selection: ");

        while (true) {
            i = scan.nextInt();
            if (i > 0 && i < 4) {
                break;
            }
            else {
                System.out.println("Invalid Selection!");
            }
        }
        return i;
    }

    public static void main(String[] args) {

        System.out.println("\n**********************************");
        System.out.println("Caesar Cipher in Java");
        System.out.println("**********************************\n");

        mainloop:

        while (true) {
            switch (menu()) {
                case 1: System.out.println("\nEncrypt selected");
                    Scanner strmessage = new Scanner(System.in);
                    System.out.println("Enter the string to encrypt: ");
                    String message = strmessage.nextLine();
                    Scanner intoffset = new Scanner(System.in);
                    System.out.println("Enter the offset value: ");
                    int offset = intoffset.nextInt();
                    String cipheredMessage = cipher(message, offset);
                    System.out.println("Offset: " + offset);
                    System.out.println("Ciphered Message: " + cipheredMessage);
                    break;
                case 2: System.out.println("\nDecrypt selected");
                    Scanner strmessage2 = new Scanner(System.in);
                    System.out.println("Enter the string to decrypt: ");
                    String message2 = strmessage2.nextLine();
                    Scanner intoffset2 = new Scanner(System.in);
                    System.out.println("Enter the offset value: ");
                    int offset2 = intoffset2.nextInt();
                    String cipheredMessage2 = decrypt(message2, offset2);
                    System.out.println("Offset: " + offset2);
                    System.out.println("Decrypted Message: " + cipheredMessage2);
                    break;
                case 3: System.out.println("Quiting!");
                    break mainloop;
            };
        }

    }

}