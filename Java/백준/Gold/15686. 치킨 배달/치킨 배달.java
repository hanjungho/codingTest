import java.util.*;
import java.io.*;

class Coordinate {
    
    int x;
    int y;
    
    Coordinate (int x, int y) {
        
        this.x = x;
        this.y = y;
    }
}

public class Main {
    
    static int n, m;
    static List<Coordinate> homes = new ArrayList<>();
    static List<Coordinate> chickens = new ArrayList<>();
    
    static int ans = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                
                int a = Integer.parseInt(st.nextToken());
                
                if (a == 1) {
                    
                    homes.add(new Coordinate(i, j));
                } else if (a == 2) {
                    
                    chickens.add(new Coordinate(i, j));
                };
            }
        }
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        bt(0, new int[m], 0);
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    public static void bt (int cnt, int[] chickenArr, int start) {
        
        if (cnt == m) {
            
            ans = Math.min(ans, minDistance(chickenArr));
            
            return;
        }
        
        for (int i = start; i < chickens.size(); i++) {
            
            chickenArr[cnt] = i;
            
            bt(cnt + 1, chickenArr, i + 1);
        }
    }
    
    public static int minDistance (int[] chickenArr) {
        
        int total = 0;
        
        for (int i = 0; i < homes.size(); i++) {
            
            int x = homes.get(i).x;
            int y = homes.get(i).y;
            
            int min = 200;
            
            for (int j = 0; j < chickenArr.length; j++) {
                
                int xDis = chickens.get(chickenArr[j]).x - x;
                int yDis = chickens.get(chickenArr[j]).y - y;
                
                xDis *= xDis < 0 ? -1 : 1;
                yDis *= yDis < 0 ? -1 : 1;
                
                min = Math.min(min, xDis + yDis);
            }
            
            total += min;
        }
        
        return total;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}