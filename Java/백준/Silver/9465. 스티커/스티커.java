import java.io.*;
import java.util.*;

class TC {
    
    int n;
    int[][] sticker;
    
    TC(int n, int[][] sticker) {
        
        this.n = n;
        this.sticker = sticker;
    }
}

public class Main {
    
    static int t;
    static TC[] testCase;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        String line = br.readLine();
        
        if (line == null) return;
        
        t = Integer.parseInt(line);
        testCase = new TC[t];
        
        for (int i = 0; i < t; i++) {
            
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                sticker[0][j] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                sticker[1][j] = Integer.parseInt(st.nextToken());
            }
            
            testCase[i] = new TC(n, sticker);
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            
            int n = testCase[i].n;
            int[][] dp = testCase[i].sticker;
            
            if (n >= 2) {
                
                dp[0][1] += dp[1][0];
                dp[1][1] += dp[0][0];
            }
            
            for (int j = 2; j < n; j++) {
                
                dp[0][j] += Math.max(dp[1][j - 1], dp[1][j - 2]);
                dp[1][j] += Math.max(dp[0][j - 1], dp[0][j - 2]);
            }
            
            int ans = Math.max(dp[0][n - 1], dp[1][n - 1]);
            sb.append(ans).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        bw.flush();
    }
}