import java.io.*;
import java.util.*;

public class Main{
    
    static long a;
    static long b;
    
    static int ans = -1;
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            a = Long.parseLong(st.nextToken());
            b = Long.parseLong(st.nextToken());
            
            count(a, 1);
            
            bw.write(String.valueOf(ans));
            
            bw.flush();
        }
    }
    
    private static void count(long num, int cnt) {
        
        if (num == b) {
            
            if (ans == -1) {
                
                ans = cnt;
            } else {
                
                ans = Math.min(ans, cnt);
            }
            
            return;
        } else if (num > b) {
            
            return;
        }
        
        count(num * 2, cnt + 1);
        count(num * 10 + 1, cnt + 1);
    }
}