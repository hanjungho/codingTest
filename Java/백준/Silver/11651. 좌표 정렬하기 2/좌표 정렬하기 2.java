import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[][] coordinates;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        coordinates = new int[n][2];
        
        StringTokenizer st;
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            coordinates[i][0] = Integer.parseInt(st.nextToken());
            coordinates[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(coordinates, (coor1, coor2) -> {
            
            if (coor1[1] == coor2[1]) {
                return coor1[0] - coor2[0];
            }
            
            return coor1[1] - coor2[1];
        });
        
        for (int i = 0; i < n; i++) {
            
            sb.append(coordinates[i][0]).append(" ").append(coordinates[i][1]).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}