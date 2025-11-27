import java.util.*;
import java.io.*;

public class Main {
    
    static List<Boolean> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        int a = 0;
        int b = 0;
        
        while(true) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0) {
                
                break;
            }
            
            if (a > b) {
                
                list.add(true);
            } else {
                
                list.add(false);
            }
        }
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (Boolean b : list) {
            
            if (b) {
                
                sb.append("Yes\n");
            } else {
                
                sb.append("No\n");
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}