import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    static int m;
    
    static int[][] mapArr;
    
    static int[] targetPoint = new int[2];
    
    static int[][] resultArr;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           ) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        mapArr = new int[n][m];
        
        resultArr = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(resultArr[i], -1);
        }
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                
                mapArr[i][j] = Integer.parseInt(st.nextToken());
                
                if (mapArr[i][j] == 2) {
                    targetPoint[0] = i;
                    targetPoint[1] = j;
                    
                    resultArr[i][j] = 0;
                } else if (mapArr[i][j] == 0) {
                    
                    resultArr[i][j] = 0;
                }
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        bfs();
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < m; j++) {
                
                sb.append(String.valueOf(resultArr[i][j]));
                if (j < m - 1) sb.append(" ");
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    public static void bfs() {
        
        Deque<Integer[]> dq = new ArrayDeque<>();
        
        dq.addLast(new Integer[]{targetPoint[0], targetPoint[1]});
        
        while (dq.isEmpty() == false) {
            
            Integer[] coordinate = dq.removeFirst();
        
            int x = coordinate[0];
            int y = coordinate[1];
        
            for (int i = 0; i < 4; i++) {
            
                int movedX = x + dx[i];
                int movedY = y + dy[i];
            
                if (movedX < 0 || movedX >= n || movedY < 0 || movedY >= m) {
                    continue;
                }
            
                if (resultArr[movedX][movedY] != -1) {
                    continue;
                }
            
                if (mapArr[movedX][movedY] == 0) {
                    continue;
                }
            
                dq.addLast(new Integer[]{movedX, movedY});
                resultArr[movedX][movedY] = resultArr[x][y] + 1;
            }
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}