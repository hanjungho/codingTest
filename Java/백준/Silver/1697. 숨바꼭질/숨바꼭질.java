import java.util.*;
import java.io.*;

class Point {
    
    int coordinate;
    int cnt;
    
    Point (int coordinate, int cnt) {
        
        this.coordinate = coordinate;
        this.cnt = cnt;
    }
}

public class Main {
    
    static int n;
    
    static int k;
    
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
        
        k = Integer.parseInt(st.nextToken());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Deque<Point> dq = new ArrayDeque<>();
        
        dq.addLast(new Point(n, 0));
        
        boolean[] visited = new boolean[140001];
        
        visited[n] = true;
        
        while (true) {
            
            Point p = dq.removeFirst();
            
            int num = p.coordinate;
            int cnt = p.cnt;
            
            if (num == k) {
                
                sb.append(String.valueOf(cnt));
                break;
            }
            
            if (num > k) {
                
                if (num - 1 >= 0 && visited[num - 1] == false) {
                    
                    visited[num - 1] = true;
                    dq.addLast(new Point(num - 1, cnt + 1));
                }
                
                continue;
            }
            
            if (num - 1 >= 0 && visited[num - 1] == false) {
                
                visited[num - 1] = true;
                dq.addLast(new Point(num - 1, cnt + 1));
            }
            if (num + 1 <= 140000 && visited[num + 1] == false) {
                
                visited[num + 1] = true;
                dq.addLast(new Point(num + 1, cnt + 1));
            }
            if (num * 2 <= 140000 && visited[num * 2] == false) {
                
                visited[num * 2] = true;
                dq.addLast(new Point(num * 2, cnt + 1));
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}