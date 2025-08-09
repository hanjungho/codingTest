import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    
    static int[] numOfIngredient;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        numOfIngredient = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            numOfIngredient[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        Arrays.sort(numOfIngredient);
        
        int startIndex = 0;
        int endIndex = n - 1;
        
        int count = 0;
        
        while (startIndex != endIndex) {
            
            int sum = numOfIngredient[startIndex] + numOfIngredient[endIndex];
            
            if (sum < m) {
                startIndex++;
            } else if (sum > m) {
                endIndex--;
            } else {
                startIndex++;
                count++;
            }
        }
        
        return String.valueOf(count);
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
    
    
}