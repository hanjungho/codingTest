import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    static int[][] dot;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        dot = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            dot[i][0] = Integer.parseInt(st.nextToken());
            dot[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        long sum = 0;
        
        for (int i = 0; i < n; i++) {
            
            int next = (i + 1) % n;
            
            sum += (long) dot[i][0] * dot[next][1] - (long) dot[next][0] * dot[i][1];
        }
        
        if (sum < 0) {
            
            sum *= -1;
        }
        
        double ans = sum / 2.0;
        
        sb.append(String.format("%.1f", ans));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}