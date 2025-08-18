import java.util.*;
import java.io.*;

class Coordinate {
    
    int x;
    int y;
    
    Coordinate(int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static Coordinate[] coordinates;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        coordinates = new Coordinate[n];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            
            int y = Integer.parseInt(st.nextToken());
            
            coordinates[i] = new Coordinate(x, y);
        }
        
        br.close();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(coordinates, (a, b) -> {
            if (a.x == b.x) {
                return a.y - b.y;
            }
            
            return a.x - b.x;
        });
        
        for (int i = 0; i < n; i++){
            
            sb.append(coordinates[i].x).append(" ").append(coordinates[i].y).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}