import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[] s;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        s = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            
            s[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int ans = 0;
        
        int left = 0;
        
        Map<Integer, Integer> count = new HashMap<>();
        
        for (int right = 0; right < n; right++) {
            
            count.put(s[right], count.getOrDefault(s[right], 0) + 1);
            
            while (count.size() > 2) {
                
                count.put(s[left], count.get(s[left]) - 1);
                
                if (count.get(s[left]) == 0) {
                    
                    count.remove(s[left]);
                }
                
                left++;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}