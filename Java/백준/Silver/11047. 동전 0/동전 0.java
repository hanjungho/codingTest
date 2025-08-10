import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int k;
    
    static int[] coins;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        k = Integer.parseInt(st.nextToken());
        
        coins = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            coins[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        int coin = k;
        
        int count = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            
            int curCoin = coins[i];
            
            count += coin / curCoin;
            
            coin %= curCoin;
        }
        
        answer.append(String.valueOf(count));
        
        return answer.toString();
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
