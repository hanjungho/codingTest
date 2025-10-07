import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int m;
    
    static int[][] matrix;
    
    static int[][] quiz;
    
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
        
        matrix = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        quiz = new int[m][4];
        
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < 4; j ++) {
                
                quiz[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] sum = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++){
                
                if (j == 0) {
                    
                    sum[i][j] = matrix[i][j];
                    continue;
                }
                sum[i][j] = sum[i][j - 1] + matrix[i][j];
            }
        }
        
        for (int i = 1; i < n; i++) {
            
            for (int j = 0; j < n; j++){
                
                sum[i][j] = sum[i][j] + sum[i - 1][j];
            }
        }
        
        for (int i = 0; i < m; i++) {
            
            int x1 = quiz[i][0] - 1;
            int y1 = quiz[i][1] - 1;
            int x2 = quiz[i][2] - 1;
            int y2 = quiz[i][3] - 1;
            
            int ans = sum[x2][y2];
            
            if (x1 != 0) {
                
                ans -= sum[x1 - 1][y2];
            }
            
            if (y1 != 0) {
                
                ans -= sum[x2][y1 - 1];
            }
            
            if (x1 != 0 && y1 != 0) {
                
                ans += sum[x1 - 1][y1 - 1];
            }
            
            sb.append(String.valueOf(ans)).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}