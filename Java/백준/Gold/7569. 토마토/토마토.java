import java.util.*;
import java.io.*;

class Coordinate {
    
    int h;
    int n;
    int m;
    
    Coordinate(int h, int n, int m) {
        
        this.h = h;
        this.n = n;
        this.m = m;
    }
}

public class Main {
    
    static int m, n, h;
    
    static int[][][] box;
    
    static Deque<Coordinate> dq;
    
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
        h = Integer.parseInt(st.nextToken());
        
        box = new int[h][n][m];
        
        dq = new ArrayDeque<>();
        
        for (int i = 0; i < n * h ; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                
                box[i / n][i % n][j] = Integer.parseInt(st.nextToken());
                
                if (box[i / n][i % n][j] == 1) {
                    dq.addLast(new Coordinate(i / n, i % n, j));
                }
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[] dh = {-1, 1, 0, 0, 0, 0};
        int[] dn = {0, 0, -1, 1, 0, 0};
        int[] dm = {0, 0, 0, 0, -1, 1};
        
        Deque<Coordinate> nextDq = new ArrayDeque<>();
        
        int cnt = 0;
        
        while (!dq.isEmpty()) {
            
            Coordinate c = dq.removeFirst();
            
            int ch = c.h;
            int cn = c.n;
            int cm = c.m;
            
            for (int i = 0; i < 6; i++) {
                
                int nh = ch + dh[i];
                int nn = cn + dn[i];
                int nm = cm + dm[i];
                
                if (0 <= nh && nh < h && 0 <= nn && nn < n && 0 <= nm && nm < m && box[nh][nn][nm] == 0) {
                    
                    box[nh][nn][nm] = 1;
                    nextDq.addLast(new Coordinate(nh, nn, nm));
                }
            }
            
            if (dq.isEmpty()) {
                
                if (!nextDq.isEmpty()) {
                    
                    cnt++;
                }
                dq = nextDq;
                nextDq = new ArrayDeque<>();
            }
        }
        
        if (checkZero()) {
            
            sb.append("-1");
        } else {
            
            sb.append(String.valueOf(cnt));
        }
        
        return sb.toString();
    }
    
    private static boolean checkZero() {
        
        for (int i = 0; i < h; i++) {
            
            for (int j = 0; j < n; j++) {
                
                for (int k = 0; k < m; k++) {
                    
                    if (box[i][j][k] == 0) {
                        
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}