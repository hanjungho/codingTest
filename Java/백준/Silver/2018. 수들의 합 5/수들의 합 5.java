import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
    }
    
    public static String solve() {
        
        int[] numArr = new int[N];
        
        int sum = 1;
        int count = 1;
        
        for (int i = 0; i < N; i++) {
            
            numArr[i] = i + 1;
        }
        
        int startIndex = 0;
        int endIndex = 0;
        
        while (startIndex < N - 1) {
            
            if (sum < N) {
                endIndex++;
                sum += numArr[endIndex];
            } else if (sum > N) {
                sum -= numArr[startIndex];
                startIndex++;
            } else {
                endIndex++;
                sum += numArr[endIndex];
                count++;
            }
        }
        
        return String.valueOf(count);
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        br.close();
        bw.flush();
        bw.close();
    }
}