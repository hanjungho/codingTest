import java.util.*;
import java.io.*;

public class Main {
    
    static int[] arr = new int[3];
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        arr[0] = Integer.parseInt(st.nextToken());
        
        arr[1] = Integer.parseInt(st.nextToken());
        
        arr[2] = Integer.parseInt(st.nextToken());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(arr);
        
        sb.append(String.valueOf(arr[1]));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}