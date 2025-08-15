import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    static int[] inputArr;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        inputArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            inputArr[i] = Integer.parseInt(br.readLine());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        Arrays.sort(inputArr);
        
        for (int i = 0; i < n; i++) {
            
            sb.append(inputArr[i]).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}