import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    
    static String[] inputtedCommands;
    
    static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    static void input() throws IOException {

        n = Integer.parseInt(br.readLine());
        
        inputtedCommands = new String[n];
        
        for (int i = 0; i < n; i++) {
            
            inputtedCommands[i] = br.readLine();
        }
        
        br.close();
    }
    
    static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            
            String result = command(inputtedCommands[i]);
            
            if (result == null) {
                continue;
            }
            
            sb.append(result).append("\n");
        }
        
        return sb.toString();
    }
    
    static String command(String cmdStr) {
        
        String[] commands = {"push", "pop", "size", "empty", "top"};
        
        String[] strs = cmdStr.split(" ");
        
        String result = "-1";
        
        if (strs[0].equals(commands[0])) {
            
            dq.addFirst(Integer.parseInt(strs[1]));
            
            return null;
        } else if (strs[0].equals(commands[1])) {
            
            try {
                result = String.valueOf(dq.removeFirst());
            } catch (Exception e) {
                result = "-1";
            }
            
        } else if (strs[0].equals(commands[2])) {
            
            result = String.valueOf(dq.size());
        } else if (strs[0].equals(commands[3])) {
            
            result = dq.isEmpty() ? "1" : "0";
        } else if (strs[0].equals(commands[4])) {
            
            result = String.valueOf(dq.peekFirst() == null ? -1 : dq.peekFirst());
        }
        
        return result;
    }
    
    static void output(String ans) throws IOException {
        bw.write(ans);
        
        bw.flush();
        bw.close();
    }
}