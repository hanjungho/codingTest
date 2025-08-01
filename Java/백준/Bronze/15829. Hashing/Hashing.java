import java.util.*;
import java.io.*;

public class Main {
    
    public static int R = 31;
    public static int M = 1234567891;
    
    public static void main (String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int l = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        String str = st.nextToken();
        
        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(hash(l, str)));
        bw.flush();
        bw.close();
    }
    
    public static long hash (int l, String str) {
        
        long result = 0;
        long powR = 1;
        
        for (int i = 0; i < l; i++) {
            long a = str.charAt(i) - 'a' + 1;
            
            result = (result + (a * powR) % M) % M;
            
            powR = (powR * R) % M;
        }
        
        return result;
    }
}