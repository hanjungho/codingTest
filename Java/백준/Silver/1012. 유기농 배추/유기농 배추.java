import java.io.*;
import java.util.*;

public class Main {
    
    static int m, n;
    static int[][] land;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int t = Integer.parseInt(br.readLine());
            
            for (int testCase = 0; testCase < t; testCase++) {
                input(br);
                int result = solve();
                bw.write(result + "\n");
            }
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        land = new int[m][n];
        
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            land[x][y] = 1;
        }
    }
    
    public static int solve() {
        int cnt = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    cnt++;
                    dfs(i, j);
                }
            }
        }
        
        return cnt;
    }
    
    public static void dfs(int x, int y) {
        land[x][y] = 0;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && nx < m && ny >= 0 && ny < n && land[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}