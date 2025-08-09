import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int[] inputArr;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        inputArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        Arrays.sort(inputArr);
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            int curNum = inputArr[i];
            int leftIdx = 0;
            int rightIdx = n - 1;
            while (leftIdx < rightIdx) {
                if (leftIdx == i) {
                    leftIdx++;
                    continue;
                }
                
                if (rightIdx == i) {
                    rightIdx--;
                    continue;
                }
                
                if (curNum == inputArr[leftIdx] + inputArr[rightIdx]) {
                    count++;
                    break;
                } else if (curNum > inputArr[leftIdx] + inputArr[rightIdx]) {
                    leftIdx++;
                } else {
                    rightIdx--;
                }
            }
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
