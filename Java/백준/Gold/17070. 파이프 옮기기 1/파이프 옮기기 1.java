import java.util.*;
import java.io.*;

class Pipe {
    
    int x;
    int y;
    State state;
    
    Pipe (int x, int y, State state) {
        
        this.x = x;
        this.y = y;
        this.state = state;
    }
}

enum State {
    
    WIDTH,
    LENGTH,
    DIAGONAL
}

public class Main {
    
    static int n;
    
    static int[][] home;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        home = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(bfs()));
        
        return sb.toString();
    }
    
    public static int bfs() {
        
        Deque<Pipe> dq = new ArrayDeque<>();
        
        dq.addLast(new Pipe(0, 1, State.WIDTH));
        
        int cnt = 0;
        
        while (!dq.isEmpty()) {
            
            Pipe pipe = dq.removeFirst();
            
            int x = pipe.x;
            int y = pipe.y;
            State state = pipe.state;
            
            if (x == n - 1 && y == n - 1) {
                
                cnt++;
                continue;
            }
            
            boolean widthAble = false;
            boolean lengthAble = false;
            boolean diagonalAble = false;
            
            if (state == State.WIDTH) {
                
                widthAble = true;
                diagonalAble = true;
            } else if (state == State.LENGTH) {
                
                lengthAble = true;
                diagonalAble = true;
            } else if (state == State.DIAGONAL) {
                
                widthAble = true;
                lengthAble = true;
                diagonalAble = true;
            }
            
            if (x + 1 >= n || home[x + 1][y] == 1) {
                
                lengthAble = false;
                diagonalAble = false;
            }
            
            if (x + 1 >= n || y + 1 >= n || home[x + 1][y + 1] == 1) {
                
                diagonalAble = false;
            }
            
            if (y + 1 >= n || home[x][y + 1] == 1) {
                
                widthAble = false;
                diagonalAble = false;
            }
            
            if (widthAble && y + 1 < n) {
                
                dq.addLast(new Pipe(x, y + 1, State.WIDTH));
            }
            
            if (lengthAble && x + 1 < n) {
                
                dq.addLast(new Pipe(x + 1, y, State.LENGTH));
            }
            
            if (diagonalAble && x + 1 < n && y + 1 < n) {
                
                dq.addLast(new Pipe(x + 1, y + 1, State.DIAGONAL));
            }
        }
        
        return cnt;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}