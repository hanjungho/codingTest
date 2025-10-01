import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            
            bw.write(String.valueOf(power(a, b, c)));
            bw.flush();
        }
    }
    
    public static long power(long a, long b, long c) {
        
        if (b == 0) return 1;
        
        a %= c;
        
        long half = power(a, b / 2, c);
        
        half = (half * half) % c;
        
        if (b % 2 == 1) {
            
            half = (half * a) % c;
        }
        
        return half;
    }
}