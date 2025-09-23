import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static long m;
    
    static int[] treeHeights;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        
        treeHeights = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            
            treeHeights[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        Arrays.sort(treeHeights);
        
        int cnt = 0;
        long total = Arrays.stream(treeHeights).mapToLong(x -> x).sum();
        
        for (int i = 0; i < n; i++) {
            
            total -= treeHeights[i];
            cnt++;
            
            if (m > (total - ((long)(n - cnt) * treeHeights[i]))) {
                
                total += treeHeights[i];
                cnt--;
                
                break;
            }
        }
        
        long result = (total - m) / (n - cnt);
        
        return String.valueOf(result);
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}