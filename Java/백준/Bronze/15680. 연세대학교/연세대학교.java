import java.io.*;
import java.util.*;

public class Main {
    
    static String a;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        a = br.readLine();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        if (a.equals("0")) {
            
            sb.append("YONSEI");
        } else {
            
            sb.append("Leading the Way to the Future");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}