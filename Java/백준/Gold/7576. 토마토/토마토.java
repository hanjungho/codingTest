import java.io.*;
import java.util.*;

class Coordinate {
    
    int x;
    int y;
    
    Coordinate(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            int m;
            int n;
            
            int[][] box;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            
            box = new int[n][m];
            
            Deque<Coordinate> dq = new ArrayDeque<>();
            
            int unripeCount = 0;
            
            for (int i = 0; i < n; i++) {
                
                st = new StringTokenizer(br.readLine());
                
                for (int j = 0; j < m; j++) {
                    
                    box[i][j] = Integer.parseInt(st.nextToken());
                    
                    if (box[i][j] == 1) {
                        
                        dq.addLast(new Coordinate(i, j));
                    } else if (box[i][j] == 0) {
                        unripeCount++;
                    }
                }
            }
            
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            
            int count = dq.size();
            int ans = 0;
            
            while(!dq.isEmpty()) {
                
                Coordinate curTomato = dq.removeFirst();
                
                count--;
                
                for (int i = 0; i < 4; i++) {
                    
                    int x = curTomato.x + dx[i];
                    int y = curTomato.y + dy[i];
                    
                    if (0 <= x && x < n && 0 <= y && y < m && box[x][y] == 0) {
                        
                        box[x][y] = 1;
                        dq.addLast(new Coordinate(x, y));
                        
                        unripeCount--;
                    }
                }
                
                if (count == 0 && dq.size() != 0) {
                    
                    count += dq.size();
                    
                    ans++;
                }
                
            }
            
            if (unripeCount != 0) {
                
                ans = -1;
            }
            
            bw.write(String.valueOf(ans));
            bw.flush();
        }
    }
}