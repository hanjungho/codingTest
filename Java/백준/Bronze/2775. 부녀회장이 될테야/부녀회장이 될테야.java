import java.util.*;
import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int t = Integer.parseInt(st.nextToken());
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            bw.write(String.valueOf(countResidents(k, n)));
            bw.newLine();
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static int countResidents (int floor, int number) {
        
        if (floor == 0) {
            return number;
        }
        
        int count = 0;
        
        for (int i = 1; i <= number; i++) {
            
            count += countResidents(floor - 1, i);
        }
        
        return count;
    }
}