import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        br.close();
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(decomposition(n)));
        bw.flush();
        bw.close();
    }
    
    public static int decomposition (int n) {
        
        int lengthOfN = String.valueOf(n).length();
        int min = n - (9 * lengthOfN) > 0 ? n - (9 * lengthOfN) : 0;
        for (int i = min; i < n; i++) {
            
            String[] numbers = String.valueOf(i).split("");
            
            int sum = i;
            
            for (int j = 0; j < numbers.length; j++) {
                sum += Integer.parseInt(numbers[j]);
            }
            
            if (sum == n) {
                return i;
            }
        }
        
        return 0;
    }
}