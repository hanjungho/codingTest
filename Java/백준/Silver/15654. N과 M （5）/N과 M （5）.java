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
        
        find(new int[m], 0, new boolean[n]);
        
        return sb.toString();
    }
    
    public static void find(int[] ans, int cnt, boolean[] visited) {
        
        if (cnt == m) {
            
            for (int i = 0; i < m - 1; i++) {
                
                sb.append(String.valueOf(ans[i])).append(" ");
            }
            sb.append(String.valueOf(ans[m - 1])).append("\n");
            
            return;
        }
        
        for (int i = 0; i < n; i++) {
            
            if (visited[i]) {
                
                continue;
            }
            
            visited[i] = true;
            ans[cnt] = inputArr[i];
            
            find(ans, cnt + 1, visited);
            
            visited[i] = false;
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}