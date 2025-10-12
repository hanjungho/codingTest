import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    static BigInteger a, b;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = new BigInteger(st.nextToken());
        
        b = new BigInteger(st.nextToken());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(a.add(b)));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}