import java.io.*;
import java.util.*;

public class Main {
    
    static int numOfComputer;
    
    static int numOfPair;
    
    static int[][] pair;
    
    static int[] connectedNode;
    
    public static void main(String[] args) throws IOException {
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
           ) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        numOfComputer = Integer.parseInt(br.readLine());
        
        numOfPair = Integer.parseInt(br.readLine());
        
        pair = new int[numOfPair][2];
        
        StringTokenizer st;
        
        for (int i = 0; i < numOfPair; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            pair[i][0] = Integer.parseInt(st.nextToken());
            pair[i][1] = Integer.parseInt(st.nextToken());
        }
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        connectedNode = new int[numOfComputer + 1];
        
        for (int i = 0; i < numOfComputer + 1; i++) {
            
            connectedNode[i] = i;
        }
        
        for (int i = 0; i < numOfPair; i++) {
            
            connect(pair[i][0], pair[i][1]);
        }
        
        int cnt = 0;
        
        for (int i = 2; i < numOfComputer + 1; i++) {
            
            if (find(i) == 1) {
                cnt++;
            }
        }
        
        sb.append(String.valueOf(cnt));
        
        return sb.toString();
    }
    
    public static int find(int idx) {
        
        if (connectedNode[idx] != idx) {
            
            connectedNode[idx] = find(connectedNode[idx]);
        }
        
        return connectedNode[idx];
    }
    
    public static void connect(int idx1, int idx2) {
        
        int root1 = find(idx1);
        
        int root2 = find(idx2);
        
        int min = Math.min(root1, root2);
        
        int max = Math.max(root1, root2);
        
        connectedNode[max] = min;
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}