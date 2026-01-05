import java.io.*;
import java.util.*;

public class Main {
    
    static int r, c, t;
    static int[][] map;
    static int[] airPurifier;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        
        map = new int[r][c];
        
        boolean check = false;
        
        airPurifier = new int[2];
        
        for (int i = 0; i < r; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < c; j++) {
                
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (!check && map[i][j] == -1) {
                    
                    check = true;
                    
                    airPurifier[0] = i;
                    airPurifier[1] = j;
                }
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            
            diffusion();
            purifie();
        }
        
        int ans = 2;
        
        for (int i = 0; i < r; i++) {
            
            for (int j = 0; j < c; j++) {
                
                ans += map[i][j];
            }
        }
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    private static void diffusion() {
        
        int[][] newMap = new int[r][c];
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        for (int i = 0; i < r; i++) {
            
            Arrays.fill(newMap[i], 0);
        }
        
        for (int i = 0; i < r; i++) {
            
            for (int j = 0; j < c; j++) {
                
                if (map[i][j] == -1) {
                    
                    newMap[i][j] = -1;
                }
                
                if (map[i][j] != -1 && map[i][j] != 0) {
                    
                    int value = map[i][j] / 5;
                    
                    int curValue = map[i][j];
                    
                    for (int k = 0; k < 4; k++) {
                        
                        int x = i + dx[k];
                        int y = j + dy[k];
                        
                        if (x < 0 || x >= r || y < 0 || y >= c || map[x][y] == - 1) {
                            
                            continue;
                        }
                        
                        newMap[x][y] += value;
                        
                        curValue -= value;
                    }
                    
                    newMap[i][j] += curValue;
                }
            }
        }
        
        map = newMap;
    }
    
    private static void purifie() {
        
        int topX = airPurifier[0];
        int topY = airPurifier[1];
        int bottomX = topX + 1;
        int bottomY = topY;
        
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        
        int x = bottomX + 1;
        int y = bottomY;
        
        int idx = 0;
        
        while(x != bottomX || y != bottomY) {
            
            map[x - dx[idx]][y - dy[idx]] = map[x][y];
            
            x += dx[idx];
            y += dy[idx];
            
            if (x < bottomX || x >= r || y < 0 || y >= c) {
                
                x -= dx[idx];
                y -= dy[idx];
                
                idx++;
                
                if (idx >= 4) {
                    
                    break;
                }
                
                x += dx[idx];
                y += dy[idx];
            }
        }
        
        map[bottomX][bottomY] = -1;
        map[bottomX][bottomY + 1] = 0;
        
        dx = new int[]{-1, 0, 1, 0};
        
        x = topX - 1;
        y = topY;
        
        idx = 0;
        
        while(x != topX || y != topY) {
            
            map[x - dx[idx]][y - dy[idx]] = map[x][y];
            
            x += dx[idx];
            y += dy[idx];
            
            if (x < 0 || x > topX || y < 0 || y >= c) {
                
                x -= dx[idx];
                y -= dy[idx];
                
                idx++;
                
                if (idx >= 4) {
                    
                    break;
                }
                
                x += dx[idx];
                y += dy[idx];
            }
        }
        
        map[topX][topY] = -1;
        map[topX][topY + 1] = 0;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}