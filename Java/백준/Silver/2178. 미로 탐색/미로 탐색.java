import java.util.*;
import java.io.*;

class Coordinate {
    
    int x;
    int y;
    int cnt;
    
    Coordinate(int x, int y, int cnt) {
        
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class Main {
    
    static int n, m;
    
    static boolean[][] map;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
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
        
        map = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            
            String[] inpArr = br.readLine().split("");
            
            for (int j = 0; j < m; j++) {
                
                map[i][j] = inpArr[j].equals("1") ? true : false;
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(bfs()));
        
        return sb.toString();
    }
    
    public static int bfs() {
        
        Deque<Coordinate> dq = new ArrayDeque<>();
        
        dq.addLast(new Coordinate(0, 0, 1));
        map[0][0] = false;
        
        while (!dq.isEmpty()) {
            
            Coordinate c = dq.removeFirst();
            
            int x = c.x;
            int y = c.y;
            int cnt = c.cnt;
            
            if (x == n - 1 && y == m - 1) {
                
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                
                int x1 = x + dx[i];
                int y1 = y + dy[i];
                
                if (0 <= x1 && x1 < n && 0 <= y1 && y1 < m) {
                    
                    if (map[x1][y1] == true) {
                        
                        map[x1][y1] = false;
                        
                        dq.addLast(new Coordinate(x1, y1, cnt + 1));
                    }
                }
            }
        }
        
        return -1;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}