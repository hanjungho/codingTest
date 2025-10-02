import java.util.*;
import java.io.*;
public class Main {
    
    static int n;
    
    static int[][] houses;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        houses = new int[n][3];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            houses[i][0] = Integer.parseInt(st.nextToken());
            houses[i][1] = Integer.parseInt(st.nextToken());
            houses[i][2] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] dp = new int[n][3];
        
        // dp[n][0] = min(dp[n - 1][1] + houses[n][0], dp[n - 1][2] + houses[n][0])
        
        dp[0] = houses[0];
        
        for (int i = 1; i < n; i++) {
            
            dp[i][0] = Math.min(dp[i - 1][1] + houses[i][0], dp[i - 1][2] + houses[i][0]);
            dp[i][1] = Math.min(dp[i - 1][0] + houses[i][1], dp[i - 1][2] + houses[i][1]);
            dp[i][2] = Math.min(dp[i - 1][1] + houses[i][2], dp[i - 1][0] + houses[i][2]);
        }
        
        int ans = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}