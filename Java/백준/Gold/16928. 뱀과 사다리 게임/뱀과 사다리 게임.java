import java.util.*;
import java.io.*;

class Position {
    
    int point;
    int cnt;
    
    Position (int point, int cnt) {
        
        this.point = point;
        this.cnt = cnt;
    }
}

public class Main {
    
    static int n;
    
    static int m;
    
    static Map<Integer, Integer> ladder = new HashMap<>();
    
    static Map<Integer, Integer> snake = new HashMap<>();
    
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
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Deque<Position> dq = new ArrayDeque<>();
        
        dq.addLast(new Position(1, 0));
        
        boolean[] visited = new boolean[101];
        
        while (true) {
            
            Position now = dq.removeFirst();
            
            int point = now.point;
            int cnt = now.cnt;
            
            if (point == 100) {
                
                sb.append(String.valueOf(cnt));
                
                break;
            }
            
            for (int i = 1; i < 7; i++) {
                
                if (point + i > 100) {
                    
                    break;
                }
                
                if (visited[point + i]) {
                    
                    continue;
                }
                
                if (ladder.get(point + i) != null || snake.get(point + i) != null) {
                    
                    int next = ladder.get(point + i) == null ? snake.get(point + i) : ladder.get(point + i);
                
                    dq.addLast(new Position(next, cnt + 1));
                
                    continue;
                }
                
                dq.addLast(new Position(point + i, cnt + 1));
                visited[point + i] = true;
            }
            
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}