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
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
        
            String[][] inputArr = new String[n][m];
            
            boolean[][] visited = new boolean[n][m];
            
            Deque<Coordinate> coorDq = new ArrayDeque<>();
            
            for (int i = 0; i < n; i++) {
                
                inputArr[i] = br.readLine().split("");
                
                for (int j = 0; j < m; j++) {
                    
                    if (inputArr[i][j].equals("I")) {
                        
                        coorDq.addLast(new Coordinate(i, j));
                    }
                }
            }
            
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            
            int cnt = 0;
            
            while (!coorDq.isEmpty()) {
                
                Coordinate coor = coorDq.removeFirst();
                
                int x = coor.x;
                int y = coor.y;
                
                cnt += inputArr[x][y].equals("P") ? 1 : 0;
                
                for (int i = 0; i < 4; i++) {
                    
                    if (x + dx[i] < 0 || x + dx[i] >= n || y + dy[i] < 0 || y + dy[i] >= m || visited[x + dx[i]][y + dy[i]] || inputArr[x + dx[i]][y + dy[i]].equals("X")) {
                        
                        continue;
                    }
                    
                    visited[x + dx[i]][y + dy[i]] = true;
                    coorDq.addLast(new Coordinate(x + dx[i], y + dy[i]));
                }
            }
            
            if (cnt == 0) {
                
                bw.write("TT");
            } else {
                
                bw.write(String.valueOf(cnt));
            }
            
            bw.flush();
            
       }
    }
}