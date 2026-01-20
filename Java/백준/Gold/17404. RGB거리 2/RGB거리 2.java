import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    static int[][] rgb;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        rgb = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 3; j++) {
                
                rgb[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        // dp[i][0][0] = Math.min(dp[i - 1][1][0], dp[i - 1][2][0]) + rgb[i][0]
        // dp[i][1][0] = Math.min(dp[i - 1][0][0], dp[i - 1][2][0]) + rgb[i][1]
        // dp[i][2][0] = Math.min(dp[i - 1][0][0], dp[i - 1][1][0]) + rgb[i][2]
        // dp[i][0][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + rgb[i][0]
        // dp[i][1][1] = Math.min(dp[i - 1][0][1], dp[i - 1][2][1]) + rgb[i][1]
        // dp[i][2][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + rgb[i][2]
        // dp[i][0][2] = Math.min(dp[i - 1][1][2], dp[i - 1][2][2]) + rgb[i][0]
        // dp[i][1][2] = Math.min(dp[i - 1][0][2], dp[i - 1][2][2]) + rgb[i][1]
        // dp[i][2][2] = Math.min(dp[i - 1][0][2], dp[i - 1][1][2]) + rgb[i][2]
        // if (i == n - 1) {
        //    dp[i][1][0] = Math.min(dp[i - 1][0][0], dp[i - 1][2][0]) + rgb[i][1]
        //    dp[i][1][2] = Math.min(dp[i - 1][0][2], dp[i - 1][2][2]) + rgb[i][1]
        //    dp[i][0][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + rgb[i][0]
        //    dp[i][0][2] = Math.min(dp[i - 1][1][2], dp[i - 1][2][2]) + rgb[i][0]
        //    dp[i][2][0] = Math.min(dp[i - 1][0][0], dp[i - 1][1][0]) + rgb[i][2]
        //    dp[i][2][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + rgb[i][2]
        // }
        
        int ans = Integer.MAX_VALUE;
        
        int[][][] dp = new int[n][3][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                
                Arrays.fill(dp[i][j], Integer.MAX_VALUE - 1000);
            }
        }
        
        dp[0][0][0] = rgb[0][0];
        dp[0][1][1] = rgb[0][1];
        dp[0][2][2] = rgb[0][2];
        
        for (int i = 1; i < n; i++) {
            
            if (i == n - 1) {
                
                ans = Math.min(Math.min(dp[i - 1][0][0], dp[i - 1][2][0]) + rgb[i][1], ans);
                ans = Math.min(Math.min(dp[i - 1][0][2], dp[i - 1][2][2]) + rgb[i][1], ans);
                ans = Math.min(Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + rgb[i][0], ans);
                ans = Math.min(Math.min(dp[i - 1][1][2], dp[i - 1][2][2]) + rgb[i][0], ans);
                ans = Math.min(Math.min(dp[i - 1][0][0], dp[i - 1][1][0]) + rgb[i][2], ans);
                ans = Math.min(Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + rgb[i][2], ans);
            } else {
                
                dp[i][0][0] = Math.min(dp[i - 1][1][0], dp[i - 1][2][0]) + rgb[i][0];
                dp[i][1][0] = Math.min(dp[i - 1][0][0], dp[i - 1][2][0]) + rgb[i][1];
                dp[i][2][0] = Math.min(dp[i - 1][0][0], dp[i - 1][1][0]) + rgb[i][2];
                dp[i][0][1] = Math.min(dp[i - 1][1][1], dp[i - 1][2][1]) + rgb[i][0];
                dp[i][1][1] = Math.min(dp[i - 1][0][1], dp[i - 1][2][1]) + rgb[i][1];
                dp[i][2][1] = Math.min(dp[i - 1][0][1], dp[i - 1][1][1]) + rgb[i][2];
                dp[i][0][2] = Math.min(dp[i - 1][1][2], dp[i - 1][2][2]) + rgb[i][0];
                dp[i][1][2] = Math.min(dp[i - 1][0][2], dp[i - 1][2][2]) + rgb[i][1];
                dp[i][2][2] = Math.min(dp[i - 1][0][2], dp[i - 1][1][2]) + rgb[i][2];
            }
        }
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}