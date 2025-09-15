import java.util.*;
import java.io.*;
public class Main {
    
    static int n;
    
    static int m;
    
    static Set<String> 듣잡 = new HashSet<>();
    
    static Set<String> 보잡 = new HashSet<>();
    
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
        
        for (int i = 0; i < n; i++) {
            
            듣잡.add(br.readLine());
        }
        
        for (int i = 0; i < m; i++) {
            
            보잡.add(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Set<String> 듣보잡 = 듣잡;
        
        듣보잡.retainAll(보잡);
        
        sb.append(String.valueOf(듣보잡.size())).append("\n");
        
        String[] 듣보잡배열 = 듣보잡.toArray(new String[0]);
        
        Arrays.sort(듣보잡배열);
        
        for (String 듣보잡이신분 : 듣보잡배열) {
            
            sb.append(듣보잡이신분).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}