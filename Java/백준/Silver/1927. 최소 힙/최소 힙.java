import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[] inputArr;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        inputArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            inputArr[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            
            int num = inputArr[i];
            
            if (num == 0) {
                
                if (heap.isEmpty()) {
                    
                    sb.append("0");
                } else {
                    
                    sb.append(String.valueOf(heap.remove()));
                }
                sb.append("\n");
                
            } else {
                
                heap.add(num);
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}