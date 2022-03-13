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
public class ReverseSort {
    private static final boolean DEBUG = false;
    private static int solve(int n, int[] list) {
        int cost = 0;
        for(int i = 0; i < n; i++){
            int j = minPos(list,i+1);
            list = reverse(list, i, j);
            cost += (j - i) + 1;
        }

        return cost;


    }


    private static int minPos(int[] list, int i){
        int min = i;
        for(int x = i; x < list.length; x++){
            if(list[min] <= list[x]){
                min = x;
            }
        }
        return min;
    }
    private static int[] reverse(int[] list, int i, int j){
        for(int x = i; x < j; x++){
            list[x] = list[j - i - 1];
        }
        return list;
    }



    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for(int i = 0; i < testCount; i++){
                int n = scanner.nextInt();
                int[] list = new int[n];
                for(int j = 0; j < n; j++){
                    list[j] = scanner.nextInt();
                }
                int result = solve(n, list);
                System.out.println("Case #" + i + ": " + result);
            }
        }
        
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}