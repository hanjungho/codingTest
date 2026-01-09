import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    static int[] input;
    
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
        
        input = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int start = 0;
        int end = n - 1;
        
        int num1 = 0;
        int num2 = n - 1;
        
        int value = Integer.MAX_VALUE;
        
        while (start < end) {
            
            if (Math.abs(input[start] + input[end]) <= value) {
                
                num1 = start;
                num2 = end;
                
                value = Math.abs(input[start] + input[end]);
            }
            
            if (Math.abs(input[start]) < Math.abs(input[end])) {
                
                end--;
            } else {
                
                start++;
            }
        }
        
        sb.append(String.valueOf(input[num1])).append(" ").append(String.valueOf(input[num2]));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}