import java.util.*;
import java.io.*;

public class Main {
    
    static int n, r, c;
    
    static int ans, cnt;
    
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
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        cnt = 0;
        
        int size = 1;
        
        for (int i = 0; i < n; i++) {
            
            size *= 2;
        }
        
        ans = -1;
        
        cntOrder(0, size - 1, 0, size - 1);
        
        sb.append(String.valueOf(ans));
        
        sb.append("\n");
        
        return sb.toString();
    }
    
    public static void cntOrder(int xStart, int xEnd, int yStart, int yEnd) {
        
        if (ans != -1) {
            
            return;
        }
        
        if (!(xStart <= r && r <= xEnd && yStart <= c && c <= yEnd)) {
            
            cnt += (xEnd - xStart + 1) * (yEnd - yStart + 1);
            return;
        }
        
        if (xEnd - xStart == 1 && yEnd - yStart == 1) {
            
            if (xStart == r && yStart == c) {
                
                ans = cnt;
            } else if (xStart == r && yEnd == c) {
                
                ans = cnt + 1;
            } else if (xEnd == r && yStart == c) {
                
                ans = cnt + 2;
            } else if (xEnd == r && yEnd == c) {
                
                ans = cnt + 3;
            } else {
                
                cnt += 4;
            }
            
        } else {
            
            cntOrder(xStart, (xStart + xEnd) / 2, yStart, (yStart + yEnd) / 2);
            cntOrder(xStart, (xStart + xEnd) / 2, ((yStart + yEnd) / 2) + 1, yEnd);
            cntOrder(((xStart + xEnd) / 2) + 1, xEnd, yStart, (yStart + yEnd) / 2);
            cntOrder(((xStart + xEnd) / 2) + 1, xEnd, ((yStart + yEnd) / 2) + 1, yEnd);
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}