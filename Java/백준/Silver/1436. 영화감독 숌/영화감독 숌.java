import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
    }
    
    public static String solve() {
        
        // 666 1666 2666 3666 4666 5666 6661 6662 6663 6664 6665 6666 11666 12666 13666 14666 15666 16661 16662 16663 16664 16665 16666 21666 22666 23666 24666 25666 26661 26662 26663 26664 26665 26666 ...
        
        int result = 666;
        int count = 1;
        
        while (count != n) {
            
            result++;
            count += contain666(result) ? 1 : 0;
        }
        
        return String.valueOf(result);
    }
    
    public static boolean contain666 (int num) {
        
        return String.valueOf(num).contains("666");
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}