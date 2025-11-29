import java.util.*;
import java.io.*;

public class Main {
    
    static boolean[][] visited;
    
    static int n;
    static int m;
    
    static int[][] map;
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    static int sum = 0;
    
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
        
        map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                visited[i][j] = true;
                
                search(i, j, 1, map[i][j]);
                
                visited[i][j] = false;
            }
        }
        
        sb.append(String.valueOf(sum));
        
        return sb.toString();
    }
    
    public static void search(int x, int y, int cnt, int result) {
        
        if (cnt == 4) {
            
            if (result > sum) {
                
                sum = result;
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                
                visited[nx][ny] = true;
                
                search(nx, ny, cnt + 1, result + map[nx][ny]);
                
                visited[nx][ny] = false;
                
                if (cnt == 2) {
                    
                    visited[nx][ny] = true;
                    
                    search(x, y, cnt + 1, result + map[nx][ny]);
                    
                    visited[nx][ny] = false;
                }
            }
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}