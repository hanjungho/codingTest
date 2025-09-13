import java.util.*;
import java.io.*;

public class Main {
    
    static int m;
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        String inputStr = br.readLine();
        
        String[] inputArr = inputStr.split(" ");
        
        m = Integer.parseInt(inputArr[0]);
        n = Integer.parseInt(inputArr[1]);
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[] checkArr = new int[n + 1];
        checkArr[1] = 1;
        
        for (int i = 2; i < n + 1; i++) {
            
            int multiple = 2;
            
            while (multiple * i <= n) {
                
                checkArr[multiple * i] = multiple * i;
                
                multiple++;
            }
        }
        
        for (int i = m; i < n + 1; i++) {
            
            if (checkArr[i] != i) {
                
                sb.append(String.valueOf(i)).append("\n");
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}