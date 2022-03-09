import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.io.IOException;
import java.io.Writer;
import java.io.OutputStreamWriter;
import java.io.InputStream;
import java.lang.Math;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author kode
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        ProblemSolver solver = new ProblemSolver();
        solver.solve(in, out);
        out.close();
    }


    // Algorithm here
    static class ProblemSolver {
        int width;
        int height;
        int reward;
        int[] x;
        int[] y;
        int[] latency;
        int numAntenna;
        int numBuild;
        int[] connSpeed;
        int[] antRange;
        int[] antSpeed;
        int[][] matrix;
        int[][] coordAnt;
        int[] antCov; 
        int[] antRew;
        int[] ids;
        int placed;

        public void solve(InputReader in, OutputWriter out) {
            width = in.nextInt();
            height = in.nextInt();
            numBuild = in.nextInt();
            numAntenna = in.nextInt();
            reward = in.nextInt();
            x = new int[numBuild];
            y = new int[numBuild];
            latency = new int[numBuild];
            connSpeed = new int[numBuild];
            antRange = new int[numAntenna];
            antSpeed = new int[numAntenna];
            coordAnt = new int[2][numAntenna];
            antCov = new int[numAntenna];
            antRew = new int[numAntenna];
            ids = new int[numAntenna];
            placed = 0;

            for(int i = 0; i < numBuild; i++){
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                latency[i] = in.nextInt();
                connSpeed[i] = in.nextInt();
            }

            for(int j = 0; j < numAntenna; j++){
                antRange[j] = in.nextInt();
                antSpeed[j] = in.nextInt();
            }

            matrix = new int[width][height];
            for(int i = 0; i < width; i++){
                for(int j = 0; j < height; j++){
                    matrix[i][j] = 0;
                }
            }

            for(int i = 0; i < numAntenna; i++){
                coordAnt[0][i] = -1;
                coordAnt[1][i] = -1;
                antCov[i] = 0;
                antRew[i] = 0;
                ids[i] = -1;
            }

            for(int i = 0; i < numAntenna; i++){
                int maxX = 0;
                int maxY = 0;
                int curX = maxX;
                int curY = maxY;
                for(int j = 0; j < width; j++){
                    for(int z = 0; z < height; z++){
                        curX = j;
                        curY = z;
                        int cov = 0;
                        for(int q = 0; q < numBuild; q++){
                            int dist = dist(x[q], y[q], curX, curY);
                            if(dist < antRange[i] && connSpeed[q] <= antSpeed[i]){
                                cov++;
                            }
                        }
                        if(cov > antCov[i]){
                            antCov[i]++;
                            maxX = curX;
                            maxY = curY;
                        }

                    }
                }
            coordAnt[0][i] = maxX;
            coordAnt[1][i] = maxY;
            if(antCov[i] == numAntenna){
                antRew[i] = reward;
            }

            if(antCov[i] > 0){
                placed++;
                ids[i] = 1;
            }

            }
        
            out.printf("\n%d", placed);
            for(int i = 0; i < numAntenna; i++){
                if(ids[i] > 0){
                    out.printf("\n%d %d %d", i, coordAnt[0][i], coordAnt[1][i]);
                }
            }
            out.printf("\n");
        }

        static int dist(int x, int y, int x1, int y1){
            return (int) Math.sqrt(Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
        }




    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void printf(String format, Object... objects) {
            writer.printf(format, objects);
        }

        public void close() {
            writer.close();
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1 << 16];
        private int curChar;
        private int numChars;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (this.numChars == -1) {
                throw new UnknownError();
            } else {
                if (this.curChar >= this.numChars) {
                    this.curChar = 0;

                    try {
                        this.numChars = this.stream.read(this.buf);
                    } catch (IOException var2) {
                        throw new InputMismatchException();
                    }

                    if (this.numChars <= 0) {
                        return -1;
                    }
                }

                return this.buf[this.curChar++];
            }
        }

        public int nextInt() {
            int c;
            for (c = this.read(); isSpaceChar(c); c = this.read()) {
                ;
            }

            byte sgn = 1;
            if (c == 45) {
                sgn = -1;
                c = this.read();
            }

            int res = 0;

            while (c >= 48 && c <= 57) {
                res *= 10;
                res += c - 48;
                c = this.read();
                if (isSpaceChar(c)) {
                    return res * sgn;
                }
            }

            throw new InputMismatchException();
        }

        public String next() {
            int c;
            while (isSpaceChar(c = this.read())) {
                ;
            }

            StringBuilder result = new StringBuilder();
            result.appendCodePoint(c);

            while (!isSpaceChar(c = this.read())) {
                result.appendCodePoint(c);
            }

            return result.toString();
        }

        public static boolean isSpaceChar(int c) {
            return c == 32 || c == 10 || c == 13 || c == 9 || c == -1;
        }

    }
}

