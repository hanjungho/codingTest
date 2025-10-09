import java.util.*;
import java.io.*;

public class Main {
    
    static int k;
    
    static int n;
    
    static long[] lanLength;
    
    static long totalSum = 0;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken());
        
        n = Integer.parseInt(st.nextToken());
        
        lanLength = new long[k];
        
        for (int i = 0; i < k; i++) {
            
            lanLength[i] = Long.parseLong(br.readLine());
            
            totalSum += lanLength[i];
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        long max = totalSum / k + 1;
        
        long min = 1;
        
        while (max > min) {
            
            long mid = (min + max) / 2;
            
            long cnt = 0;
            
            for (int i = 0; i < k; i++) {
                
                cnt += lanLength[i] / mid;
            }
            
            if (cnt >= n) {
                
                min = mid + 1;
            } else {
                
                max = mid;
            }
        }
        
        sb.append(String.valueOf(max - 1));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}