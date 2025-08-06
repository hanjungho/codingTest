import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static String damagedNumber;
    
    public static void main(String[] args) throws IOException {
        
        inputData();
        
        bw.write(String.valueOf(findAnswer()));
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void inputData() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        damagedNumber = st.nextToken();
    }
    
    public static int findAnswer() {
        
        int sum = 0;
        boolean isOdd = true;
        
        for (int i = 0; i < 13; i++) {
            if (damagedNumber.charAt(i) == '*') {
                if (i % 2 == 0) {
                    isOdd = true;
                } else {
                    isOdd = false;
                }
                continue;
            }
            int num = damagedNumber.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += num;
            } else {
                sum += num * 3;
            }
        }
        
        int result = (10 - (sum % 10)) % 10;
        
        if (isOdd) {
            return result;
        } else {
            while (result % 3 != 0) {
                result += 10;
            }
            result /= 3;
            return result;
        }
    }
}