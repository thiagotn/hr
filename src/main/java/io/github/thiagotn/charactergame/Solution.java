package io.github.thiagotn.charactergame;

import java.util.Scanner;

// https://www.hackerrank.com/contests/dstest-1/challenges/character-game 
public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int cases = scanner.nextInt();

        int count = 0;
        while (scanner.hasNextLine() && count < cases) {
            String currentString = scanner.nextLine();
            if (currentString.isEmpty()) continue;
            int position = findFirstNonRepeatingCharacter(currentString);
            if (position < 0) {
                System.out.println(position);
            } else {
                System.out.println(currentString.charAt(position));
            }
            count++;
        }

        scanner.close();
    }

    private static int findFirstNonRepeatingCharacter(String word) {
        int[] char_counts = new int[255];
        // fill array with all chars contained in 'word'
        // and incrementing each item with amount of occurrences
        for (char c : word.toCharArray()){
            int numericValue = (int) c;
            System.out.println("char: " + c + " - " + numericValue);
            char_counts[numericValue]++;
        }

        // for each item and return the first with size 1
        for (char c : word.toCharArray()) {
            int numericValue = (int) c;
            if (char_counts[numericValue] == 1) {
                return word.indexOf(c);
            }
        }
        return -1;
    }
}