import java.util.*;
import java.io.*;

public class Main {
    
    static int[] scores = new int[5];
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        for (int i = 0; i < 5; i++) {
            
            scores[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int sum = 0;
        
        for (int i = 0; i < 5; i++) {
            
            if (scores[i] < 40) {
                
                sum += 40;
            } else {
                
                sum += scores[i];
            }
        }
        
        sb.append(String.valueOf(sum / 5));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}