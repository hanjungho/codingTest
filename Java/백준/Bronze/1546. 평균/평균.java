import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    
    static int[] SCORES;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        SCORES = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            
            SCORES[i] = Integer.parseInt(st.nextToken());
        }
        
    }
    
    public static String solve() {
        
        int max = Arrays.stream(SCORES)
                        .max()
                        .getAsInt();
        
        double newAverage = Arrays.stream(SCORES)
                                .mapToDouble(score -> (double) score / (double) max * 100)
                                .average()
                                .orElse(0.0);
        
        return String.valueOf(newAverage);
        
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        br.close();
        bw.flush();
        bw.close();
    }
}