import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[][] inputArr;
    
    static List<List<Integer>> graph = new ArrayList<>();
    
    static boolean[] visited;
    
    static int[] ans;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        inputArr = new int[n - 1][2];
        
        for (int i = 0; i < n - 1; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            inputArr[i][0] = Integer.parseInt(st.nextToken());
            inputArr[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n + 1; i++) {
            
            graph.add(new ArrayList<>());
        }
        
        visited = new boolean[n + 1];
        
        ans = new int[n + 1];
        
        for (int i = 0; i < n - 1; i++) {
            
            int node1 = inputArr[i][0];
            int node2 = inputArr[i][1];
            
            graph.get(node1).add(node2);
            graph.get(node2).add(node1);
        }
        
        dfs(1, 1);
        
        for (int i = 2; i < n + 1; i++) {
            
            sb.append(String.valueOf(ans[i])).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void dfs(int post, int cur) {
        
        for (int node : graph.get(cur)) {
            
            if (!visited[node]) {
                
                ans[node] = cur;
                visited[node] = true;
                dfs(cur, node);
            }
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}