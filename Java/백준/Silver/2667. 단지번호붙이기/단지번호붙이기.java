import java.util.*;
import java.io.*;

class Coordinate {
    
    int x;
    int y;
    
    Coordinate(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int n;
    
    static int[][] map;
    
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            String[] sArr = br.readLine().split("");
            
            for (int j = 0; j < n; j++) {
                
                map[i][j] = Integer.parseInt(sArr[j]);
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Deque<Coordinate> dq = new ArrayDeque<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (map[i][j] == 1) {
                    
                    int cnt = 1;
                    
                    map[i][j] = 0;
                    
                    dq.addLast(new Coordinate(i, j));
                    
                    while(!dq.isEmpty()) {
                        
                        Coordinate c = dq.removeFirst();
                        
                        int x = c.x;
                        int y = c.y;
                        
                        for (int k = 0; k < 4; k++) {
                            
                            int x1 = x + dx[k];
                            int y1 = y + dy[k];
                            
                            if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n) {
                                
                                continue;
                            }
                            
                            if (map[x1][y1] == 1) {
                                
                                map[x1][y1] = 0;
                                
                                dq.addLast(new Coordinate(x1, y1));
                                
                                cnt++;
                            }
                        }
                    }
                    
                    pq.add(cnt);
                }
            }
        }
        
        sb.append(String.valueOf(pq.size())).append("\n");
        
        while (!pq.isEmpty()) {
            
            int num = pq.remove();
            
            sb.append(String.valueOf(num)).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}