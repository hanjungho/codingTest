import java.util.*;
import java.io.*;
public class Main {
    
    static int n;
    
    static int m;
    
    static Map<String, String> passwords = new HashMap<>();
    
    static String[] quizs;
    
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
            
            st = new StringTokenizer(br.readLine());
            
            passwords.put(st.nextToken(), st.nextToken());
        }
        
        quizs = new String[m];
        
        for (int i = 0; i < m; i++) {
            
            quizs[i] = br.readLine();
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            
            sb.append(passwords.get(quizs[i])).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}