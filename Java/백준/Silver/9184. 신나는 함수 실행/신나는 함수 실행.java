import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static List<List<Integer>> inputList = new ArrayList<>();
    
    static Integer[][][] memoization = new Integer[21][21][21];
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        while (true) {
            if (a == -1 && b == -1 && c == -1) {
                break;
            }
            
            inputList.add(Arrays.asList(a, b, c));
            
            st = new StringTokenizer(br.readLine());
            
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < inputList.size(); i++) {
            
            answer.append("w(").append(String.valueOf(inputList.get(i).get(0))).append(", ").append(String.valueOf(inputList.get(i).get(1))).append(", ").append(String.valueOf(inputList.get(i).get(2))).append(") = ").append(String.valueOf(w(inputList.get(i).get(0), inputList.get(i).get(1), inputList.get(i).get(2)))).append("\n");
        }
        
        return answer.toString();
    }

    public static int w(int a, int b, int c) {
        
        int result = 1;
        
        if (a <= 0 || b <= 0 || c <= 0) {
            result = 1;
        } else if (a > 20 || b > 20 || c > 20) {
            result = w(20, 20, 20);
        } else if (memoization[a][b][c] == null) {
            if (a < b && b < c) {
                result = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
            } else {
                result = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
            }
            
            memoization[a][b][c] = result;
        } else {
            result = memoization[a][b][c];
        }
        
        return result;
        
    }
    
    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
