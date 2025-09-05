import java.util.*;
import java.io.*;

public class Main {
    
    static int numOfStairs;
    
    static int[] pointOfStairs;
    
    static int[][] dp;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        numOfStairs = Integer.parseInt(br.readLine());
        
        pointOfStairs = new int[numOfStairs];
        
        for (int i = 0; i < numOfStairs; i++) {
            
            pointOfStairs[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        dp = new int[numOfStairs + 1][3];
        
        // dp[n][1] = max(dp[n - 2][1], dp[n - 2][2]) + pointOfStairs[n - 1]
        // dp[n][2] = dp[n - 1][1] + pointOfStairs[n - 1]
        
        if (numOfStairs == 1) {
            
            return String.valueOf(pointOfStairs[0]);
        }
        
        if (numOfStairs == 1) {
            
            return String.valueOf(pointOfStairs[0] + pointOfStairs[1]);
        }
        
        dp[1][1] = pointOfStairs[0];
        dp[1][2] = -1;
        
        dp[2][1] = pointOfStairs[1];
        dp[2][2] = pointOfStairs[0] + pointOfStairs[1];
        
        for (int i = 3; i < numOfStairs + 1; i++) {
            
            dp[i][1] = Math.max(dp[i - 2][1], dp[i - 2][2]) + pointOfStairs[i - 1];
            dp[i][2] = dp[i - 1][1] + pointOfStairs[i - 1];
        }
        
        return String.valueOf(Math.max(dp[numOfStairs][1], dp[numOfStairs][2]));
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}