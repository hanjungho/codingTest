import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        Deque<Integer> numberBySize = new ArrayDeque<Integer>();
        for (int i = 0; i < 6; i++) {
            numberBySize.push(Integer.parseInt(st.nextToken()));
        }
        
        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        br.close();
        
        int numberOfTBundle = 0;
        
        for (int i = 0; i < 6; i++) {
            int numberOfSize = numberBySize.pop();
            numberOfTBundle += numberOfSize / t;
            if (numberOfSize % t > 0) {
                numberOfTBundle++;
            }
        }
        
        int numberOfPenBundle = n / p;
        int numberOfPen = n % p;
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(numberOfTBundle));
        bw.newLine();
        bw.write(numberOfPenBundle + " " + numberOfPen);
        bw.flush();
        bw.close();
    }
}