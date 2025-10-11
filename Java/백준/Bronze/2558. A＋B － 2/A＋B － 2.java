import java.util.*;
import java.io.*;

public class Main {
    
    static int a, b;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        a = Integer.parseInt(br.readLine());
        
        b = Integer.parseInt(br.readLine());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(a + b));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}