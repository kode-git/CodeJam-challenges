package Vestigium;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 
 * @author kode
 */
public class Vestigium {
    private static final boolean DEBUG = false;

    private static int[] solve(int n, int[][] matrix) {
        int[] result = new int[3];
        int trace = 0;

        // count rows with duplicates

        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
            Boolean r = false;
            Boolean c = false;
            for (int j = 0; j < n; j++) {
                for(int z = 0; z < j; z++){
                    if(matrix[i][j] == matrix[i][z]){
                        r = true;
                    }
                    if(matrix[j][i] == matrix[z][i]){
                        c = true;
                    }
                }
            }
            if(r) row++;
            if(c) col++;
            r = false;
            c = false;
        }
               

        result[0] = trace;
        result[1] = row;
        result[2] = col;
        return result;

    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            int[][] results = new int[testCount][3];
            for (int i = 0; i < testCount; i++) {
                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int z = 0; z < n; z++) {
                        matrix[j][z] = scanner.nextInt();
                    }
                }
                results[i] = solve(n, matrix);
            }

            for (int i = 0; i < testCount; i++) {
                System.out.print("Case #" + (i + 1) + ": ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(" " + results[i][j]);
                }
                System.out.println();
            }
        }

        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}