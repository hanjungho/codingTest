import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int n = Integer.parseInt(br.readLine());
            
            // dp[n] = dp[n - 1] + dp[n - 2] * 2
            
            int[] dp = new int[n + 1];
            
            dp[1] = 1;
            
            if (n >= 2) {
                dp[2] = 3;
            }
            
            if (n >= 3) {
                
                for (int i = 3; i < n + 1; i++) {
                    
                    dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
                }
            }
            
            bw.write(String.valueOf(dp[n]));
            
            bw.flush();
        }
    }
}