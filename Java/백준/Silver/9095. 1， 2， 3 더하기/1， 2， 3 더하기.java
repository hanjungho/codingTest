import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[] testCases;
    
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
        
        testCases = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            testCases[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int maxCase = Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
            
            maxCase = Math.max(maxCase, testCases[i]);
        }
        
        dp = new int[maxCase + 1];
        
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        // dp[n] = dp[n - 1] + dp[n - 2] + dp[n - 3]
        
        if (maxCase > 3) {
            
            for (int i = 4; i < maxCase + 1; i++) {
            
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            int testCase = testCases[i];
            
            sb.append(dp[testCase]).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}