import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    static String INPUT_NUM;
    
    public static void main(String[] args) throws IOException {
        
        
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        INPUT_NUM = st.nextToken();
    }
    
    public static String solve() {
        
        int ans = 0;
        
        String[] inputNumArr = INPUT_NUM.split("");
        
        for (int i = 0; i < N; i++) {
            ans += Integer.parseInt(inputNumArr[i]);
        }
        
        return String.valueOf(ans);
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
        br.close();
    }
}