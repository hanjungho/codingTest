import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve(br));
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
    }
    
    public static String solve(BufferedReader br) throws IOException {
        
        StringBuilder sb = new StringBuilder();
        
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            dpMax[i] = Integer.parseInt(st.nextToken());
            dpMin[i] = dpMax[i];
        }
        
        for (int i = 1; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            int[] line = new int[3];
            for (int j = 0; j < 3; j++) {
                line[j] = Integer.parseInt(st.nextToken());
            }
            
            int[] tempMax = new int[3];
            int[] tempMin = new int[3];
            
            for (int j = 0; j < 3; j++) {
                
                tempMax[j] = Integer.MIN_VALUE;
                tempMin[j] = Integer.MAX_VALUE;
                
                for (int k = Math.max(0, j - 1); k <= Math.min(2, j + 1); k++) {
                    
                    tempMax[j] = Math.max(tempMax[j], dpMax[k] + line[j]);
                    tempMin[j] = Math.min(tempMin[j], dpMin[k] + line[j]);
                }
            }
            
            dpMax = tempMax;
            dpMin = tempMin;
        }
        
        int max = Math.max(dpMax[0], Math.max(dpMax[1], dpMax[2]));
        int min = Math.min(dpMin[0], Math.min(dpMin[1], dpMin[2]));
        
        sb.append(String.valueOf(max)).append(" ").append(String.valueOf(min));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}