import java.util.*;
import java.io.*;
public class Main {
    
    static String ans;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        int t = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < t; i++) {
            
            TreeMap<Integer, Integer> tm = new TreeMap<>();
            
            int commandCnt = Integer.parseInt(br.readLine());
            
            for (int j = 0; j < commandCnt; j++) {
                
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                String s = st.nextToken();
                
                int num = Integer.parseInt(st.nextToken());
                
                if (s.equals("I")) {
                    
                    tm.put(num, tm.getOrDefault(num, 0) + 1);
                } else if (s.equals("D")) {
                    
                    if (!tm.isEmpty()) {
                        
                        int key;
                        
                        if (num == -1) {
                            
                            key = tm.firstKey();
                        } else {
                            
                            key = tm.lastKey();
                        }
                        
                        if (tm.get(key) == 1) {
                            
                            tm.remove(key);
                        } else {
                            
                            tm.put(key, tm.get(key) - 1);
                        }
                    }
                }
            }
            
            if (tm.size() >= 1) {
                
                int big = tm.lastKey();
                int small = tm.firstKey();
                
                sb.append(String.valueOf(big)).append(" ").append(String.valueOf(small));
            } else {
                
                sb.append("EMPTY");
            }
            
            if (i != t - 1) {
                
                sb.append("\n");
            }
        }
        
        ans = sb.toString();
    }
    
    public static String solve() {
        
        return ans;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}