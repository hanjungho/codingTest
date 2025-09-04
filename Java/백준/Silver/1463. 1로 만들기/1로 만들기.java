import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           ) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[] dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 0;
        
        for (int i = 2; i < n + 1; i++) {
                        
            int min = dp[i - 1];
            
            if (i % 3 == 0) {
                
                min = Math.min(min, dp[i / 3]);
            }
            
            if (i % 2 == 0) {
                
                min = Math.min(min, dp[i / 2]);
            }
            
            dp[i] = min + 1;
        }
        
        sb.append(String.valueOf(dp[n]));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}