import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    static int[] numArr;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        numArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            numArr[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int curNum = 1;
        
        int numArrIdx = 0;
        
        Deque<Integer> deq = new ArrayDeque<>();
        
        
        while(numArrIdx < n) {
            int target = numArr[numArrIdx]; // 현재 만들어야 할 숫자
            
            // 스택 최상단이 목표 숫자와 같으면 pop
            if (!deq.isEmpty() && deq.getLast() == target) {
                deq.removeLast();
                sb.append("-" + "\n");
                numArrIdx++;
            }
            // 목표 숫자까지 push 해야 하는 경우
            else if (curNum <= target) {
                deq.addLast(curNum);
                sb.append("+" + "\n");
                curNum++;
            }
            // 목표 숫자가 이미 지나갔는데 스택 최상단에 없으면 불가능
            else {
                return "NO";
            }
        }
        
        return sb.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}