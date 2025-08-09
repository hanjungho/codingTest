import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    
    static int[] moneyDuringPeriod;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(st.nextToken());
        
        moneyDuringPeriod = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            moneyDuringPeriod[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        int left = Arrays.stream(moneyDuringPeriod).max().getAsInt();
        int right = Arrays.stream(moneyDuringPeriod).sum();
        int ans = right;
        
        while (left <= right) {
            
            int mid = (left + right) / 2;
            
            int withdrawCount = calculateWithdrawCount(mid);
            
            if (withdrawCount <= m) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        answer.append(String.valueOf(ans));
        
        return answer.toString();
    }
    
    public static int calculateWithdrawCount(int money) {
        
        int curMoney = money;
        int count = 1;
        
        for (int i = 0;  i < n; i++) {
            
            if (curMoney < moneyDuringPeriod[i]) {
                curMoney = money;
                count++;
            }
            curMoney -= moneyDuringPeriod[i];
        }
        
        return count;
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
