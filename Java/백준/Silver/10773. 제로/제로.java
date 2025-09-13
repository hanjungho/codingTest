import java.util.*;
import java.io.*;

public class Main {
    
    static int k;
    
    static int[] nums;
    
    static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        k = Integer.parseInt(br.readLine());
        
        nums = new int[k];
        
        for (int i = 0; i < k; i++) {
            
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < k; i++) {
            
            int num = nums[i];
            
            if (num == 0 && !dq.isEmpty()) {
                
                dq.removeLast();
            } else {
                
                dq.addLast(num);
            }
        }
        
        int result = 0;
        
        while (!dq.isEmpty()) {
            
            result += dq.removeLast();
        }
        
        sb.append(String.valueOf(result));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}