package AppendSort;

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
public class AppendSort {
    private static final boolean DEBUG = false;

    private static int solve(int n, int[] list) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (list[i] < list[i - 1]) {
                int el = list[i];
                if (el < list[i - 1]) {
                    boolean next = true;
                    int it = 1;
                    for (int j = 0; j < 10; j++) {
                        if (list[i - 1] + 10 * it + j > list[i]) {
                            list[i - 1] = list[i - 1] + 10 * it + j;
                            count++;
                            next = false;
                            break;
                        }
                        if(j == 9 && next){
                            j = 0;
                            list[i-1] = list[i - 1] + 10 * it + j;
                            it += 1;
                        }

                    }
                }

            }
        }
        return count;

    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int i = 0; i < testCount; i++) {
                int n = scanner.nextInt();
                int[] list = new int[n];
                for (int j = 0; j < n; j++) {
                    list[j] = scanner.nextInt();
                }
                int result = solve(n, list);
                System.out.println("Case #" + i + ": " + result);
            }
        }

        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}