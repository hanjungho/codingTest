import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
    }
    
    public static String solve() {
        
        int count = 0;
        
        for (int i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }
        
        return String.valueOf(count);
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}