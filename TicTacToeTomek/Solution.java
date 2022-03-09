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
public class Solution {
    private static final boolean DEBUG = false;
    private static String solve(int count, int dim,  char[][] matrix) {
        int result = 0;
        boolean point = false;
        boolean t = false;
        int xt = -1, yt = -1;
        int[][] val = new int[dim][dim];
        for(int i = 0; i < dim; i++){
            for(int j = 0; j < dim; j++){
                if(matrix[i][j] == '.') {
                    val[i][j] = 0;
                    point = true;
                }
                if(matrix[i][j] == 'O') val[i][j] = 1;
                if(matrix[i][j] == 'X') val[i][j] = -1;
                if(matrix[i][j] == 'T') {
                    val[i][j] = 0; 
                    t = true;
                    xt = i;
                    yt = j;
                }
            }
        }

        // control rows and cols
        int sumR = 0;
        int sumC = 0;
        int sumD = 0;
        int sumD2 = 0;
        for(int i = 0; i < dim; i++){
            sumR = 0;
            sumC = 0;
            sumD += val[i][i];
            sumD2 += val[i][dim - i - 1];
            for(int j = 0; j < dim; j++){
                sumR += val[i][j];
                sumC += val[j][i];
            }
            if(sumR == 4 || sumC == 4 || sumD == 4 || sumD2 == 4){
                result = 2;
            } else if(sumR == -4 || sumC == -4 || sumD == -4 || sumD2 == -4){
                result = 1;
            } else {
                if(t){
                    if((sumR == 3  && xt == i)|| (sumC == 3 && yt == i) || (sumD == 3 && xt == yt) || (sumD2 == 3 && (xt == (dim - yt - 1)))){
                        result = 2;
                    } else if((sumR == -3 && xt == i) || (sumC == -3 && yt == i) || (sumD == -3 && xt == yt) || (sumD2 == -3 && (xt == (dim - yt - 1)))){
                        result = 1;
                    }
                    
                }
            }
        }

        String c2;
        switch(result){
            case 0: if(point) c2 = "Game has not completed"; else c2 = "Draw"; break;
            case 1: c2 = "X won"; break;
            case 2: c2 = "O won"; break;
            default: c2 = "";
        }

        return c2;




    }



    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for(int i = 0; i < testCount; i++){
                char[][] matrix = new char[4][4];
                for(int j = 0; j < 4; j++){
                    String row = scanner.next();
                    for(int k = 0; k < 4; k++){
                        matrix[j][k]= row.charAt(k);
                    }
                }
                String result = solve(i, 4, matrix);
                System.out.println("Case #" + i + ": " + result);
            }
        }
        
        System.err.println( "Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}