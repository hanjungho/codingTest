import java.io.*;
import java.util.*;

class Node {
    
    int node, time;
    
    Node(int node, int time) {
        
        this.node = node;
        this.time = time;
    }
}

class TC {
    
    int n;
    List<Node>[] way;
    
    TC(int n, List<Node>[] way) {
        
        this.n = n;
        this.way = way;
    }
}

public class Main {
    
    static int tc;
    static TC[] tcs;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void input(BufferedReader br) throws IOException {
        
        String line = br.readLine();
        
        if (line == null) return;
        
        tc = Integer.parseInt(line);
        tcs = new TC[tc];
        
        for (int i = 0; i < tc; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            
            List<Node>[] way = new ArrayList[n + 1];
            
            for (int j = 0; j <= n; j++) {
                
                way[j] = new ArrayList<>();
            }
            
            for (int j = 0; j < m; j++) {
                
                st = new StringTokenizer(br.readLine());
                
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                way[s].add(new Node(e, t));
                way[e].add(new Node(s, t));
            }
            
            for (int j = 0; j < w; j++) {
                
                st = new StringTokenizer(br.readLine());
                
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                
                way[s].add(new Node(e, -t));
            }
            
            tcs[i] = new TC(n, way);
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < tc; i++) {
            
            int n = tcs[i].n;
            List<Node>[] way = tcs[i].way;
            
            int[] time = new int[n + 1];
            int[] cnt = new int[n + 1];
            boolean[] inQueue = new boolean[n + 1];
            
            Deque<Integer> dq = new ArrayDeque<>();
            
            for (int j = 1; j <= n; j++) {
                
                time[j] = 0;
                dq.addLast(j);
                inQueue[j] = true;
                cnt[j]++;
            }
            
            boolean hasCycle = false;
            
            while (!dq.isEmpty()) {
                
                int curr = dq.removeFirst();
                inQueue[curr] = false;
                
                for (Node nextNode : way[curr]) {
                    
                    int next = nextNode.node;
                    int cost = nextNode.time;
                    
                    if (time[next] > time[curr] + cost) {
                        
                        time[next] = time[curr] + cost;
                        
                        if (!inQueue[next]) {
                            
                            cnt[next]++;
                            
                            if (cnt[next] >= n) {
                                
                                hasCycle = true;
                                break;
                            }
                            
                            dq.addLast(next);
                            inQueue[next] = true;
                        }
                    }
                }
                
                if (hasCycle) break;
            }
            
            if (hasCycle) {
                
                sb.append("YES\n");
            } else {
                
                sb.append("NO\n");
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        bw.flush();
        bw.close();
    }

}