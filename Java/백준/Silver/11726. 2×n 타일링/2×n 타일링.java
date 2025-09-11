import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[] dp;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        dp = new int[n + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }
        // dp[n] = dp[n - 1] + dp[n - 2]
        
        if (n > 2) {
            
            for (int i = 3; i < n + 1; i++) {
            
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
        }
        
        sb.append(String.valueOf(dp[n]));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}