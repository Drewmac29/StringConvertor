/**
 * file: StringConvert.java
 * authors: Andrew Gingras
 *          Evan DiTullio
 * date: 3-26-19
 */

import java.util.Scanner;


public class StringConvert {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Initiate X and Y input strings to char []
        char[] X = scanner.nextLine().toCharArray();
        char[] Y = scanner.nextLine().toCharArray();

        // 2D S array to hold values of sub problems
        int[][] S = new int[X.length + 1][Y.length + 1];

        // Initiate 0th index of 2D array
        // S[i][0] = deletion
        // S[0][j] = insertion
        S[0][0] = 0;
        for (int i = 1; i <= X.length; i++) {
            S[i][0] = S[i-1][0] + 3; // deletion cost
        }
        for (int j = 1; j <= Y.length; j++) {
            S[0][j] = S[0][j-1] + 4; // insertion cost
        }

        // S[i][j] case of 2D array
        for (int i = 1; i <= X.length; i++ ){
            for (int j = 1; j<= Y.length; j++) {

                // Special case for S[1][j], since replacement not allowed
                if (i == 1) {
                    if (X[i - 1] == Y[j - 1]) {
                        S[i][j] = Math.min(Math.min(S[i - 1][j] + 3, S[i][j - 1] + 4), S[i - 1][j - 1]);
                    } else {
                        // Replacement not allowed
                        S[i][j] = Math.min(S[i - 1][j] + 3, S[i][j - 1] + 4);
                    }
                }
                else {
                    if (X[i - 1] == Y[j - 1]) {
                        S[i][j] = Math.min(Math.min(S[i - 1][j] + 3, S[i][j - 1] + 4), S[i - 1][j - 1]);
                    } else {
                        // Replacement case
                        S[i][j] = Math.min(Math.min(S[i - 1][j] + 3, S[i][j - 1] + 4), S[i - 2][j - 1] + 5);
                    }
                }
            }
        }
        System.out.println(S[X.length][Y.length]);
    }
}
