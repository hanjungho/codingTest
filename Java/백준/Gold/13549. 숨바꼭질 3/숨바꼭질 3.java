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
    static int k;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        String[] inputArr = br.readLine().split(" ");
        
        n = Integer.parseInt(inputArr[0]);
        k = Integer.parseInt(inputArr[1]);
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Queue<Position> pq = new PriorityQueue<>((a, b) -> {
            return a.cnt - b.cnt;
        });
        
        boolean[] visited = new boolean[100001];
        
        pq.add(new Position(n, 0));
        
        while (!pq.isEmpty()) {
            
            Position p = pq.remove();
            
            int point = p.point;
            int cnt = p.cnt;
            
            // ⭐ 이미 방문했으면 스킵
            if (visited[point]) {
                continue;
            }
            
            // ⭐ 꺼낸 후 방문 처리
            visited[point] = true;
            
            if (k == point) {
                
                sb.append(cnt);
                break;
            }
            
            // 이제 방문 체크 없이 그냥 추가
            if (point * 2 <= 100000) {
                
                pq.add(new Position(point * 2, cnt));
            }
            
            if (point + 1 <= 100000) {
                
                pq.add(new Position(point + 1, cnt + 1));
            }
            
            if (point - 1 >= 0) {
                
                pq.add(new Position(point - 1, cnt + 1));
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        bw.flush();
    }
}