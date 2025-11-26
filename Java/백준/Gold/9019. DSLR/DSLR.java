import java.util.*;
import java.io.*;

class TestCase {
    
    int a;
    int b;
    
    TestCase(int a, int b) {
        
        this.a = a;
        this.b = b;
    }
}

class State {
    
    int num;
    String command;
    
    State(int num, String command) {
        
        this.num = num;
        this.command = command;
    }
}

public class Main {
    
    static int t;
    
    static TestCase[] testCases;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        t = Integer.parseInt(br.readLine());
        
        testCases = new TestCase[t];
        
        for (int i = 0; i < t; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            
            int b = Integer.parseInt(st.nextToken());
            
            testCases[i] = new TestCase(a, b);
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            
            TestCase testCase = testCases[i];
            
            int a = testCase.a;
            int b = testCase.b;
            
            String ans = bfs(a, b);
            
            sb.append(ans).append("\n");
        }
        
        return sb.toString();
    }
    
    public static String bfs(int start, int goal) {
        
        if (start == goal) {
            
            return "";
        }
        
        Queue<State> queue = new LinkedList<>();
        
        boolean[] visited = new boolean[10000];
        
        queue.offer(new State(start, ""));
        
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            
            State cur = queue.poll();
            
            int curNum = cur.num;
            String curCommand = cur.command;
            
            // D
            int nextNum = commandD(curNum);
            if (!visited[nextNum]) {
                
                if (nextNum == goal) {
                    
                    return curCommand + "D";
                }
                
                visited[nextNum] = true;
                queue.offer(new State(nextNum, curCommand + "D"));
            }
            
            // S
            nextNum = commandS(curNum);
            if (!visited[nextNum]) {
                
                if (nextNum == goal) {
                    
                    return curCommand + "S";
                }
                
                visited[nextNum] = true;
                queue.offer(new State(nextNum, curCommand + "S"));
            }
            
            // L
            nextNum = commandL(curNum);
            if (!visited[nextNum]) {
                
                if (nextNum == goal) {
                    
                    return curCommand + "L";
                }
                
                visited[nextNum] = true;
                queue.offer(new State(nextNum, curCommand + "L"));
            }
            
            // R
            nextNum = commandR(curNum);
            if (!visited[nextNum]) {
                
                if (nextNum == goal) {
                    
                    return curCommand + "R";
                }
                
                visited[nextNum] = true;
                queue.offer(new State(nextNum, curCommand + "R"));
            }
        }
        
        return "";
    }
    
    public static int commandD(int num) {
        
        return num * 2 > 9999 ? (num * 2) % 10000 : num * 2;
    }
    
    public static int commandS(int num) {
        
        return num == 0 ? 9999 : num - 1;
    }
    
    public static int commandL(int num) {
        
        return (num * 10) % 10000 + (num / 1000);
    }
    
    public static int commandR(int num) {
        
        return (num / 10) + (num % 10) * 1000;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}