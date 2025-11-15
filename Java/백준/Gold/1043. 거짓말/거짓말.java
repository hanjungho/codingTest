import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m, knowCnt;
    
    static int[] knowNums;
    
    static int[][] partyNumArrs;
    
    static int[] unionArr;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        knowCnt = Integer.parseInt(st.nextToken());
        
        knowNums = new int[knowCnt];
        
        for (int i = 0; i < knowCnt; i++) {
            
            knowNums[i] = Integer.parseInt(st.nextToken());
        }
        
        partyNumArrs = new int[m][];
        
        for (int i = 0; i < m; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            int cnt = Integer.parseInt(st.nextToken());
            
            partyNumArrs[i] = new int[cnt];
            
            for (int j = 0; j < cnt; j++) {
                
                partyNumArrs[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        unionArr = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            
            unionArr[i] = i;
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < m; i++) {
            
            union(partyNumArrs[i]);
        }
        
        boolean[] ableToLie = new boolean[n + 1];
        
        Arrays.fill(ableToLie, true);
        
        for (int i = 0; i < knowCnt; i++) {
            
            int knowNum = knowNums[i];
            
            for (int j = 1; j < n + 1; j++) {
                
                if (find(j) == find(knowNum)) {
                    
                    ableToLie[j] = false;
                }
            }
        }
        
        int ans = 0;
        
        for (int i = 0; i < m; i++) {
            
            boolean check = true;
            
            for (int j = 0; j < partyNumArrs[i].length; j++) {
                
                if (!ableToLie[partyNumArrs[i][j]]) {
                    
                    check = false;
                }
            }
            
            if (check) {
                
                ans++;
            }
        }
        
        sb.append(String.valueOf(ans));
        
        return sb.toString();
    }
    
    public static int find(int num) {
        
        if (unionArr[num] == num) {
            
            return num;
        }
        
        unionArr[num] = find(unionArr[num]);
        
        return unionArr[num];
    }
    
    public static void union(int[] nums) {
        
        if (nums.length == 0) return;
    
        int min = find(nums[0]);
    
        for (int i = 1; i < nums.length; i++) {
            int root = find(nums[i]);
            if (root < min) {
                unionArr[min] = root;
                min = root;
            } else {
                unionArr[root] = min;
            }
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}