import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    static int K;
    
    public static void main(String[] args) throws IOException {
        
        inputData();
        
        bw.write(String.valueOf(findAnswer()));
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void inputData() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
    
    public static long findAnswer() {
        
        return factorial(N) / (factorial(K) * factorial(N - K));
    }
    
    public static long factorial(int value) {
        
        long result = 1;
        
        for (int i = 2; i <= value; i++) {
            result *= i;
        }
        
        return result;
    }
}