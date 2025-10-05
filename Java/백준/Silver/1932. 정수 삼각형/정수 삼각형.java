import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[][] triangle;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        triangle = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < i + 1; j++) {
                
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
            
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] dp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            Arrays.fill(dp[i], 0);
        }
        
        dp[0][0] = triangle[0][0];
        
        for (int i = 1; i < n; i++) {
            
            for (int j = 0; j < i + 1; j++) {
                
                //    0
                //   0 1
                //  0 1 2
                // 0 1 2 3
                //0 1 2 3 4
                
                if (j - 1 >= 0) {
                    
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + triangle[i][j]);
                }
                
                if (j < i) {
                    
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] + triangle[i][j]);
                }
                
            }
            
        }
        
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            
            max = Math.max(max, dp[n - 1][i]);
        }
        
        sb.append(max);
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}