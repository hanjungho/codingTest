import java.util.*;
import java.io.*;

public class Main {
    
    static int m;
    static int[][] operations;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        m = Integer.parseInt(br.readLine());
        
        operations = new int[m][2];
        
        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            
            // 명령어를 숫자로 변환하여 저장
            if (line[0].equals("add")) {
                operations[i][0] = 1;
                operations[i][1] = Integer.parseInt(line[1]);
            } else if (line[0].equals("remove")) {
                operations[i][0] = 2;
                operations[i][1] = Integer.parseInt(line[1]);
            } else if (line[0].equals("check")) {
                operations[i][0] = 3;
                operations[i][1] = Integer.parseInt(line[1]);
            } else if (line[0].equals("toggle")) {
                operations[i][0] = 4;
                operations[i][1] = Integer.parseInt(line[1]);
            } else if (line[0].equals("all")) {
                operations[i][0] = 5;
                operations[i][1] = 0; // 더미값
            } else if (line[0].equals("empty")) {
                operations[i][0] = 6;
                operations[i][1] = 0; // 더미값
            }
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        int S = 0; // 비트마스크로 집합 표현
        
        for (int i = 0; i < m; i++) {
            int cmd = operations[i][0];
            int x = operations[i][1];
            
            if (cmd == 1) { // add
                S |= (1 << x);
                
            } else if (cmd == 2) { // remove
                S &= ~(1 << x);
                
            } else if (cmd == 3) { // check
                if ((S & (1 << x)) != 0) {
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
                
            } else if (cmd == 4) { // toggle
                S ^= (1 << x);
                
            } else if (cmd == 5) { // all
                S = (1 << 21) - 1;
                S &= ~1; // 0번째 비트는 사용하지 않음
                
            } else if (cmd == 6) { // empty
                S = 0;
            }
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}