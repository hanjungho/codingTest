import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int m;
    static int[] inputArr;
    static StringBuilder sb = new StringBuilder();
    
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
        
        inputArr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        Arrays.sort(inputArr);
        
        boolean[] visited = new boolean[n];
        int[] result = new int[m];
        
        bt(0, visited, result);
        
        return sb.toString();
    }
    
    public static void bt(int depth, boolean[] visited, int[] result) {
        
        if (depth == m) {
            for (int i = 0; i < m; i++) {
                sb.append(result[i]);
                if (i < m - 1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int lastUsed = -1;
        
        for (int i = 0; i < n; i++) {
            
            if (!visited[i] && inputArr[i] != lastUsed) {
                
                visited[i] = true;
                result[depth] = inputArr[i];
                lastUsed = inputArr[i];
                
                bt(depth + 1, visited, result);
                
                visited[i] = false;
            }
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        bw.flush();
    }
}