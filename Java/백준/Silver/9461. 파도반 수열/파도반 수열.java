// dp[n] = dp[n - 1] + dp[n - 5]

import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    static int[] testCases;
    
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
        
        int maxCase = Arrays.stream(testCases).max().getAsInt();
        
        long[] dp = new long[maxCase + 1];
        
        dp[1] = 1;
        
        if (maxCase >= 2) {
            dp[2] = 1;
        }
        
        if (maxCase >= 3) {
            dp[3] = 1;
        }
        
        if (maxCase >= 4) {
            dp[4] = 2;
        }
        
        if (maxCase >= 5) {
            dp[5] = 2;
        }
        
        if (maxCase >= 6) {
            
            for (int i = 6; i < maxCase + 1; i++) {
                
                dp[i] = dp[i - 1] + dp[i - 5];
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            sb.append(String.valueOf(dp[testCases[i]])).append("\n");
        }
        
        return sb.toString();
        
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}