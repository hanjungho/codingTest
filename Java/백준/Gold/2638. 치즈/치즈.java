import java.io.*;
import java.util.*;

class Coordinate {
    
    int x, y;
    
    Coordinate(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int m, n;
    
    static int[][] cheese;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        cheese = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[][] visited = new int[m][n];
        
        int cnt = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        while (true) {
            
            for (int i = 0; i < m; i++) {
                
                Arrays.fill(visited[i], 0);
            }
            
            Deque<Coordinate> dq = new ArrayDeque<>();
            
            dq.addLast(new Coordinate(0, 0));
            
            visited[0][0] = 1;
            
            int[][] newCheese = new int[m][n];
            
            for (int i = 0; i < m; i++) {
                
                newCheese[i] = cheese[i].clone();
            }
            
            while (!dq.isEmpty()) {
                
                Coordinate cur = dq.removeFirst();
                
                int curX = cur.x;
                int curY = cur.y;
                
                for (int i = 0; i < 4; i++) {
                    
                    int x = curX + dx[i];
                    int y = curY + dy[i];
                    
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        
                        continue;
                    }
                    
                    if (visited[x][y] == 0 && cheese[x][y] == 0) {
                        
                        visited[x][y] = 1;
                        
                        dq.addFirst(new Coordinate(x, y));
                    } else if (cheese[x][y] == 1) {
                        
                        visited[x][y]++;
                        
                        if(visited[x][y] >= 2) {
                            
                            newCheese[x][y] = 0;
                        }
                    }
                }
            }
            
            cheese = newCheese;
            
            cnt++;
            
            boolean end = true;
            
            for (int i = 0; i < m; i++) {
                
                for (int j = 0; j < n; j++) {
                    
                    if (cheese[i][j] == 1) {
                        
                        end = false;
                    }
                }
            }
            
            if (end) {
                
                break;
            }
        }
        
        sb.append(String.valueOf(cnt));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}