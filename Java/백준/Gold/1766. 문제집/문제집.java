import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    
    static int[][] problems;
    
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        problems = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            problems[i][0] = Integer.parseInt(st.nextToken());
            problems[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        StringBuilder answer = new StringBuilder();
        
        // 1. 그래프와 진입차수 생성
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegree = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 2. problems 배열을 이용해서 그래프 구성
        for (int i = 0; i < m; i++) {
            int a = problems[i][0];  // 먼저 풀어야 할 문제
            int b = problems[i][1];  // 나중에 풀 문제
            
            graph[a].add(b);  // a → b
            indegree[b]++;    // b의 진입차수 증가
        }
        
        // 3. 우선순위 큐 (작은 번호부터)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 4. 진입차수가 0인 문제들을 큐에 추가
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }
        
        // 5. 위상정렬 수행
        while (!pq.isEmpty()) {
            int current = pq.remove();
            answer.append(current).append(" ");
            
            // 현재 문제와 연결된 다음 문제들의 진입차수 감소
            for (int next : graph[current]) {
                indegree[next]--;
                
                // 진입차수가 0이 되면 큐에 추가
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        
        return answer.toString().trim();
    }
    
    public static void output(String outputStr) throws IOException {
        bw.write(outputStr);
        bw.flush();
        bw.close();
    }
}