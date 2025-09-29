import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[] inputArr;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
        
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        inputArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder ans = new StringBuilder();
        
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        
        dp[0] = 1;
        
        int maxLength = 1;
        
        for (int i = 1; i < n; i++) {
            
            for (int j = 0; j < i; j++) {
                
                if (inputArr[j] < inputArr[i]) {
                    
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            
            maxLength = Math.max(maxLength, dp[i]);
        }
        
        ans.append(String.valueOf(maxLength));
        
        return ans.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}