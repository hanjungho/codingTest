import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int t;
    
    static String[] PSs;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    static void input() throws IOException {

        t = Integer.parseInt(br.readLine());
        
        PSs = new String[t];
        
        for (int i = 0; i < t; i++) {
            
            PSs[i] = br.readLine();
        }

        br.close();
    }

    static String solve() {
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            
            sb.append(validatePS(PSs[i])).append("\n");
        }
        
        return sb.toString();
    }
    
    static String validatePS(String PS) {
        
        Deque<String> dq = new ArrayDeque<>();
        
        String[] parenthesisArr = PS.split("");
        
        for (int i = 0; i < parenthesisArr.length; i++) {
            
            String parenthesis = parenthesisArr[i];
            
            if (parenthesis.equals("(")) {
                
                dq.addFirst("(");
            } else if(parenthesis.equals(")")) {
                
                if (dq.isEmpty()) {
                    
                    return "NO";
                }
                
                dq.removeFirst();
            }
        }
        
        if (dq.isEmpty()) {
            
            return "YES";
        }
        
        return "NO";
    }

    static void output(String ans) throws IOException {
        bw.write(ans);

        bw.flush();
        bw.close();
    }
}