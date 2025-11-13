import java.util.*;
import java.io.*;
import java.math.*;

public class Main {
    
    static BigInteger n, m;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = new BigInteger(st.nextToken());
        
        m = new BigInteger(st.nextToken());
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(n.divide(m).toString()).append("\n").append(n.remainder(m).toString());
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}