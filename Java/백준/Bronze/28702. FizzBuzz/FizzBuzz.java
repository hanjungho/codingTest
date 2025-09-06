import java.io.*;
import java.util.*;

public class Main {
    
    static String[] inputArr = new String[3];
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           ) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        for (int i = 0; i < 3; i++) {
            
            inputArr[i] = br.readLine();
        }
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 3; i++) {
            
            if (!inputArr[i].equals("Fizz") && !inputArr[i].equals("Buzz") && !inputArr[i].equals("FizzBuzz")) {
                
                int resultNum = Integer.parseInt(inputArr[i]) + 3 - i;
                
                String result = "";
                
                if (resultNum % 15 == 0) {
                    result = "FizzBuzz";
                } else if (resultNum % 3 == 0) {
                    result = "Fizz";
                } else if (resultNum % 5 == 0) {
                    result = "Buzz";
                } else {
                    result = String.valueOf(resultNum);
                }
                
                sb.append(result);
                
                break;
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}