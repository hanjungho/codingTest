import java.util.*;
import java.io.*;

class TestCase {
    
    int n;
    int m;
    int[] importances;
    
    TestCase(int n, int m, int[] importances) {
        
        this.n = n;
        this.m = m;
        this.importances = importances;
    }
}

class Importance {
    
    int importance;
    int order;
    
    Importance(int importance, int order) {
        
        this.importance = importance;
        this.order = order;
    }
}

public class Main {
    
    static int numOfTestCases;
    
    static TestCase[] testCases;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        numOfTestCases = Integer.parseInt(br.readLine());
        
        testCases = new TestCase[numOfTestCases];
        
        for (int i = 0; i < numOfTestCases; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine());
            
            int[] importances = new int[n];
            
            for (int j = 0; j < n; j++) {
                
                importances[j] = Integer.parseInt(st.nextToken());
            }
            
            testCases[i] = new TestCase(n, m, importances);
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numOfTestCases; i++) {
            
            int n = testCases[i].n;
            int m = testCases[i].m;
            int[] importances = testCases[i].importances;
            
            Deque<Importance> dq = new ArrayDeque<>();
            
            for (int j = 0; j < n; j++) {
                
                dq.addLast(new Importance(importances[j], j));
            }
            
            int order = getPrintOrder(dq, m);
            
            sb.append(String.valueOf(order)).append("\n");
        }
        
        return sb.toString();
    }
    
    public static int getPrintOrder(Deque<Importance> dq, int m) {
        
        int cnt = 0;
        
        while (!dq.isEmpty()) {
            
            int max = dq.stream()
                       .mapToInt(imp -> imp.importance)
                       .max()
                       .orElse(0);
            int first = dq.peekFirst().importance;
            
            if (max > first) {
                
                dq.addLast(dq.removeFirst());
            } else {
                
                cnt++;
                Importance importance = dq.removeFirst();
                if (importance.order == m) {
                    
                    return cnt;
                }
            }
        }
        return cnt;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}