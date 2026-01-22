import java.io.*;
import java.util.*;

class Road implements Comparable<Road> {
    
    int house;
    int cost;
    
    Road(int house, int cost) {
        
        this.house = house;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}

public class Main {
    
    static int n, m;
    
    static List<Road>[] roadInfo;
    
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
        
        roadInfo = new ArrayList[n + 1];
        
        for (int i = 0; i < n + 1; i++) {
            
            roadInfo[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            
            roadInfo[a].add(new Road(b, c));
            roadInfo[b].add(new Road(a, c));
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        boolean[] visited = new boolean[n + 1];
        
        PriorityQueue<Road> pq = new PriorityQueue<>();
        
        pq.offer(new Road(1, 0));
        
        int total = 0;
        int max = 0;
        int cnt = 0;
        
        while (!pq.isEmpty()) {
            
            Road cur = pq.poll();
            
            if (visited[cur.house]) {
                continue;
            }
            
            visited[cur.house] = true;
            
            total += cur.cost;
            
            max = Math.max(max, cur.cost);
            
            cnt++;
            
            for (int i = 0; i < roadInfo[cur.house].size(); i++) {
                
                Road next = roadInfo[cur.house].get(i);
                
                if (!visited[next.house]) {
                    pq.offer(next);
                }
            }
            
            if (cnt == n) break;
        }
        
        sb.append(String.valueOf(total - max));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}