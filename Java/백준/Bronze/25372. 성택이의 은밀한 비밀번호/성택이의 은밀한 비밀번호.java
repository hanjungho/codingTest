import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    static String[] pw;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        pw = new String[n];
        
        for (int i = 0; i < n; i++) {
            
            pw[i] = br.readLine();
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            
            if (6 <= pw[i].length() && pw[i].length() <= 9) {
                
                sb.append("yes\n");
            } else {
                
                sb.append("no\n");
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}