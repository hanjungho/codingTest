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
    
    static int n;
    
    static String[][] picture;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        picture = new String[n][n];
        
        for (int i = 0; i < n; i++) {
            
            picture[i] = br.readLine().split("");
        }
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(String.valueOf(noDisability())).append(" ").append(String.valueOf(disability()));
        
        return sb.toString();
    }
    
    public static int noDisability() {
        
        boolean[][] visited = new boolean[n][n];
        
        int ans = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (visited[i][j] == false) {
                    
                    ans++;
                    
                    visited[i][j] = true;
                    
                    Deque<Coordinate> dq = new ArrayDeque<>();
                    
                    String color = picture[i][j];
                    
                    dq.addLast(new Coordinate(i, j));
                    
                    while (!dq.isEmpty()) {
                        
                        Coordinate cd = dq.removeFirst();
                        
                        int x = cd.x;
                        int y = cd.y;
                        
                        for (int k = 0; k < 4; k++) {
                            
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if (0 <= nx && nx < n && 0 <= ny && ny < n && picture[nx][ny].equals(color) && !visited[nx][ny]) {
                                
                                dq.addLast(new Coordinate(nx, ny));
                                
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    public static int disability() {
        
        boolean[][] visited = new boolean[n][n];
        
        int ans = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n; j++) {
                
                if (visited[i][j] == false) {
                    
                    ans++;
                    
                    visited[i][j] = true;
                    
                    Deque<Coordinate> dq = new ArrayDeque<>();
                    
                    String color = picture[i][j];
                    
                    dq.addLast(new Coordinate(i, j));
                    
                    while (!dq.isEmpty()) {
                        
                        Coordinate cd = dq.removeFirst();
                        
                        int x = cd.x;
                        int y = cd.y;
                        
                        for (int k = 0; k < 4; k++) {
                            
                            int nx = x + dx[k];
                            int ny = y + dy[k];
                            
                            if (0 <= nx && nx < n && 0 <= ny && ny < n && !visited[nx][ny]) {
                                
                                if (color.equals("G") || color.equals("R")) {
                                    
                                    if (picture[nx][ny].equals("G") || picture[nx][ny].equals("R")) {
                                        
                                        dq.addLast(new Coordinate(nx, ny));
                                
                                        visited[nx][ny] = true;
                                    }
                                } else {
                                    
                                    if (picture[nx][ny].equals(color)) {
                                        
                                        dq.addLast(new Coordinate(nx, ny));
                                
                                        visited[nx][ny] = true;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        
        return ans;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}