import java.io.*;
import java.util.*;

public class Main {
    
    static int n, r, q;
    
    static List<Integer>[] tree;
    
    static int[] quiz;
    
    static int[] ans;
    
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    @SuppressWarnings("unchecked")
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        r = Integer.parseInt(st.nextToken());
        
        q = Integer.parseInt(st.nextToken());
        
        tree = new ArrayList[n + 1];
        
        for (int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            tree[a].add(b);
            tree[b].add(a);
        }
        
        quiz = new int[q];
        
        for (int i = 0; i < q; i++) {
            
            quiz[i] = Integer.parseInt(br.readLine());
        }
        
        ans = new int[n + 1];
        
        Arrays.fill(ans, 1);
        
        visited = new boolean[n + 1];
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        countNode(r);
        
        for (int i = 0; i < q; i++) {
            
            sb.append(String.valueOf(ans[quiz[i]])).append("\n");
        }
        
        return sb.toString();
    }
    
    public static int countNode(int node) {
        
        visited[node] = true;
        
        for (int i = 0; i < tree[node].size(); i++) {
            
            if (!visited[tree[node].get(i)]) {
                
                ans[node] += countNode(tree[node].get(i));
            }
        }
        
        return ans[node];
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}