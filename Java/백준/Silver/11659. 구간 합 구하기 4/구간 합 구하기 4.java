import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    static int M;
    
    static int[] N_ARRAY;
    
    static int[][] M_ARRAY;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        N_ARRAY = new int[N];
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            
            N_ARRAY[i] = Integer.parseInt(st.nextToken());
        }
        
        M_ARRAY = new int[M][2];
        
        for (int i = 0; i < M; i++) {
            
            st = new StringTokenizer(br.readLine());
            M_ARRAY[i][0] = Integer.parseInt(st.nextToken());
            M_ARRAY[i][1] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder ans = new StringBuilder();
        
        int[] cumSumArr = new int[N];
        cumSumArr[0] = N_ARRAY[0];
        
        for (int i = 1; i < N; i++) {
            
            cumSumArr[i] = cumSumArr[i - 1] + N_ARRAY[i];
        }
        
        for (int k = 0; k < M; k++) {
            
            int i = M_ARRAY[k][0];
            int j = M_ARRAY[k][1];
            
            int sum = i == 1 ? cumSumArr[j - 1] : cumSumArr[j - 1] - cumSumArr[i - 2];
            
            ans.append(sum).append("\n");
        }
        
        return ans.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        br.close();
        bw.flush();
        bw.close();
    }
}