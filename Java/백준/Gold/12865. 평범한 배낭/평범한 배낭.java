import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int k;
    static int[][] bag;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        
        bag = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());            
            
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] dp = new int[n + 1][k + 1];
        
        for (int i = 0; i < k + 1; i++) {
            dp[0][i] = 0;
        }
        
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        
        for (int i = 1; i <= n; i++) {
            
            for(int j = 1; j <= k; j++) {
                int weight = bag[i - 1][0];
                int value = bag[i - 1][1];
                int newValue = 0;
                
                if (weight <= j) {
                    
                    newValue = value + dp[i - 1][j - weight];
                }
                
                dp[i][j] = dp[i - 1][j] > newValue ? dp[i - 1][j] : newValue;
            }
        }
        
        
        sb.append(String.valueOf(dp[n][k]));
        
        return sb.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}