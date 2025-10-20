import java.util.*;
import java.io.*;

public class Main {
    
    static int a, b, c;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        a = Integer.parseInt(st.nextToken());
        
        b = Integer.parseInt(st.nextToken());
        
        c = Integer.parseInt(st.nextToken());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int[] arr = new int[3];
        
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;
        
        Arrays.sort(arr);
        
        for (int i = 0; i < 3; i++) {
            
            sb.append(String.valueOf(arr[i])).append(" ");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}