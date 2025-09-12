import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[][] humans;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        humans = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            humans[i][0] = Integer.parseInt(st.nextToken());
            humans[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            
            int wight = humans[i][0];
            int hight = humans[i][1];
            
            int cnt = 1;
            
            for (int j = 0; j < n; j++) {
                
                if (humans[j][0] > wight && humans[j][1] > hight) {
                    
                    cnt++;
                }
            }
            
            sb.append(String.valueOf(cnt)).append(" ");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}