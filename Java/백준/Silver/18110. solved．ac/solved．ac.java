import java.io.*;
import java.util.*;

public class Main {
    
    static int n;

    static int[] opinionArr;
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           ) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        opinionArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            opinionArr[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(opinionArr);
        
        int exceptionNum = (int) Math.round(n * 0.15);
        
        int cnt = 0;
        int sum = 0;
        
        for (int i = exceptionNum; i < n - exceptionNum; i++) {
            
            cnt++;
            sum += opinionArr[i];
        }
        
        int result = (int) Math.round((double) sum / cnt);
        
        sb.append(result);
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}