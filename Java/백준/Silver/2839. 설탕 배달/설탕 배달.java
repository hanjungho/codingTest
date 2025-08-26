import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        br.close();
    }
    
    public static String solve() {
        
        int[] bags = {3, 5};
        
        int maxNumOfMaxWeightBags = n / bags[1];
        
        for (int numOfMaxWeightBags = maxNumOfMaxWeightBags; numOfMaxWeightBags >= 0; numOfMaxWeightBags--) {
            
            int minNumOfBags = numOfMaxWeightBags;
            
            if ((n - (numOfMaxWeightBags * bags[1])) % bags[0] == 0) {
                
                minNumOfBags += (n - (numOfMaxWeightBags * bags[1])) / bags[0];
                
                return String.valueOf(minNumOfBags);
            }
        }
        
        return "-1";
    }
    
    public static void output(String str) throws IOException {
        
        bw.write(str);
        
        bw.flush();
        bw.close();
    }
}