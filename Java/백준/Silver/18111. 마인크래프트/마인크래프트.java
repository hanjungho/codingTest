import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, b;
    
    static int[][] blocks;
    
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
        
        m = Integer.parseInt(st.nextToken());
        
        b = Integer.parseInt(st.nextToken());
        
        blocks = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                
                blocks[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int minTime = Integer.MAX_VALUE;
        
        int resultHeight = 0;
        
        for (int target = 0; target <= 256; target++) {
            
            int remove = 0;
            
            int add = 0;
            
            for (int i = 0; i < n; i++) {
                
                for (int j = 0; j < m; j++) {
                    
                    int diff = blocks[i][j] - target;
                    
                    if (diff > 0) {
                        
                        remove += diff;
                    } else if (diff < 0) {
                        
                        add += -diff;
                    }
                }
            }
            
            if (b + remove < add) {
                
                continue;
            }
            
            int time = remove * 2 + add;
            
            if (time <= minTime) {
                
                minTime = time;
                resultHeight = target;
            }
        }
        
        sb.append(minTime).append(" ").append(resultHeight);
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}