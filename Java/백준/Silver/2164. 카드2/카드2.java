import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
    }
    
    public static String solve() {
        
        StringBuilder answer = new StringBuilder();
        
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i = 1; i <= n; i++) {
            deq.addLast(i);
        }
        
        while (deq.getFirst() != deq.getLast()) {
            
            deq.removeFirst();
            deq.addLast(deq.removeFirst());
        }
        
        answer.append(deq.removeFirst());
        
        return answer.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}
