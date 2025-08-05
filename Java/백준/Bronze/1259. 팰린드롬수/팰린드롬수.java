import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int number = Integer.parseInt(st.nextToken());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        while (number != 0) {
            
            if (palindrome(number)) {
                bw.write("yes");
            } else {
                bw.write("no");
            }
            
            bw.newLine();
            
            st = new StringTokenizer(br.readLine());
            number = Integer.parseInt(st.nextToken());
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static boolean palindrome (int number) {
        String numStr = String.valueOf(number);
        int numStrLength = numStr.length();
        String[] numStrArr = numStr.split("");
        
        for (int i = 0; i < numStrLength / 2; i++) {
            if (!numStrArr[i].equals(numStrArr[numStrLength - i - 1])) {
                return false;
            }
        }
        
        return true;
    }
}