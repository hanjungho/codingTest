import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    
    static int[] nums;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        nums = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            nums[i] = Integer.parseInt(br.readLine());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(nums);
        
        int sum = nums[0];
        
        int maxCount = 1;
        int count = 1;
        int preNum = nums[0];
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int i = 1; i < n; i++) {
            
            int num = nums[i];
            if (num == preNum) {
                
                count++;
            } else {
                
                if (count == maxCount) {
                    
                    dq.addLast(preNum);
                } else if (count > maxCount) {
                    
                    dq.clear();
                    maxCount = count;
                    
                    dq.addLast(preNum);
                }
                
                count = 1;
            }
            
            preNum = num;
            
            sum += num;
        }
        
        if (count == maxCount) {
                    
            dq.addLast(preNum);
        } else if (count > maxCount) {
                    
            dq.clear();
            maxCount = count;
                    
            dq.addLast(preNum);
        }
        
        int mode;
        
        if (dq.size() > 1) {
            
            dq.removeFirst();
            mode = dq.removeFirst();
        } else {
            mode = dq.removeFirst();
        }
        
        sb.append(String.valueOf(Math.round((double) sum / n))).append("\n");
        
        sb.append(String.valueOf(nums[n / 2])).append("\n");
        
        sb.append(String.valueOf(mode)).append("\n");
        
        sb.append(String.valueOf(nums[n - 1] - nums[0]));
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}