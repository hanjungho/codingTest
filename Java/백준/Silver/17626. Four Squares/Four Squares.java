import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int n = Integer.parseInt(br.readLine());
            
            // 1 1+1 1+1+1 / 4 4+1 4+1+1 4+1+1+1 4+4 / 9 9+1 9+1+1 9+1+1+1 9+4 9+4+1 9+4+1+1 / 
            // 16 16+1 16+1+1 16+1+1+1 16+4 16+4+1 16+4+1+1 9+9+4+1
            // dp[n] = min(dp[n - 1] + 1, dp[n - 4] + 1, dp[n - 9] + 1, ...)
            
            int[] dp = new int[n + 1];
            
            List<Integer> squareList = new ArrayList<>();
            
            for (int i = 1; i < n + 1; i++) {
                
                if (isSquare(i)) {
                    
                    squareList.add(i);
                    dp[i] = 1;
                    
                    continue;
                }
                
                dp[i] = Integer.MAX_VALUE;
                
                for (int square : squareList) {
                    
                    dp[i] = Math.min(dp[i], dp[i - square] + 1);
                }
            }
            
            bw.write(String.valueOf(dp[n]));
            bw.flush();
        }
    }
    
    public static boolean isSquare(int num) {
        
        int sqrtNum = (int) Math.sqrt(num);
        if (sqrtNum * sqrtNum == num) {
            
            return true;
        }
        
        return false;
    }
}