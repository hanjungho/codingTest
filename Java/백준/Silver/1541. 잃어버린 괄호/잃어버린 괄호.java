import java.util.*;
import java.io.*;
public class Main {
    
    static String inputStr;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        inputStr = br.readLine();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        String[] inputStrArr = inputStr.split("\\-");
        
        int inputStrArrLenght = inputStrArr.length;
        
        int 연산결과 = 0;
        
        for (int i = 0; i < inputStrArrLenght; i++) {
                
            String[] 대충덧셈할연산 = inputStrArr[i].split("\\+");
                
            int 덧셈연산결과 = 0;
                
            for (int j = 0; j < 대충덧셈할연산.length; j++) {
                    
                덧셈연산결과 += Integer.parseInt(대충덧셈할연산[j]);
            }
            
            if (i == 0) {
                
                연산결과 += 덧셈연산결과;
            } else {
                
                연산결과 -= 덧셈연산결과;
            }
        }
        
        sb.append(String.valueOf(연산결과));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}