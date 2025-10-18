import java.util.*;
import java.io.*;

public class Main {
    
    static String s;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        s = br.readLine();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        char[] charArray = s.toCharArray();
        
        int[] result = new int[26];
        
        Arrays.fill(result, 0);
        
        for (char c : charArray) {
            
            result[c - 'a'] += 1;
        }
        
        for (int i = 0; i < 26; i++) {
            
            sb.append(String.valueOf(result[i])).append(" ");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}