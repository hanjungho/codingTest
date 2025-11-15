import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static String s;
    
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        s = br.readLine();
    }
    
    public static String solve() {
        int ans = 0;
        int i = 0;
        
        while (i < m) {
            // 'I'를 찾을 때까지 진행
            if (s.charAt(i) != 'I') {
                i++;
                continue;
            }
            
            // 'I'부터 시작하는 IOI 패턴 개수 세기
            int count = 0;
            while (i + 2 < m && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') {
                count++;
                i += 2;
                
                // N개 이상의 IOI 패턴이 연속되면 카운트
                if (count >= n) {
                    ans++;
                }
            }
            
            i++;
        }
        
        return String.valueOf(ans);
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        bw.write(outputStr);
        bw.flush();
    }
}