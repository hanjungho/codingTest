import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    
    static int[] aArr;
    static int[] checkArr;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        aArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        checkArr = new int[m];
        
        for (int i = 0; i < m; i++) {
            
            checkArr[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Arrays.sort(aArr);
        
        for(int i = 0; i < m; i++) {
            
            if(Arrays.binarySearch(aArr, checkArr[i]) < 0) {
                sb.append("0");
            } else {
                sb.append("1");
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}