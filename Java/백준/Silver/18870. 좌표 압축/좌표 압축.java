import java.util.*;
import java.io.*;
public class Main {
    
    static int n;
    
    static Integer[] coor;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        coor = new Integer[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            
            coor[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Integer[] sortedUniqueCoor = new TreeSet<>(Arrays.asList(coor)).toArray(new Integer[0]);
        
        for (int i = 0; i < n; i++) {
            
            sb.append(String.valueOf(Arrays.binarySearch(sortedUniqueCoor, coor[i]))).append(" ");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}