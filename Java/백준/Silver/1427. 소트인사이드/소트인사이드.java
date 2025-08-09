import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static String inputNum;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        inputNum = st.nextToken();
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        char[] inputNumArr = inputNum.toCharArray();
        
        Arrays.sort(inputNumArr);
        
        int inputNumArrLen = inputNumArr.length;
        
        for (int i = inputNumArrLen - 1; i >= 0; i--) {
            answer.append(String.valueOf(inputNumArr[i]));
        }
        
        return answer.toString();
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
