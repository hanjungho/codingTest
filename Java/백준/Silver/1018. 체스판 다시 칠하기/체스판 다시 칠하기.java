import java.util.*;
import java.io.*;
public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int n;
    static int m;
    
    static String[][] arr;
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(st.nextToken());
        
        arr = new String[n][m];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
            
            String line = st.nextToken();
            
            arr[i] = line.split("");
        }
        
        br.close();
    }
    
    public static String solve() {
        
        // [0][0] 위치가 B일때 변경해야하면 +1, 변경할 필요없으면 +0
        int[][] arrForChange = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            
            if (i % 2 == 0) {
                if (arr[i][0].equals("W")) {
                    
                    arrForChange[i][0] = 1;
                } else {
                    
                    arrForChange[i][0] = 0;
                }
            } else {
                if (arr[i][0].equals("B")) {
                    
                    arrForChange[i][0] = 1;
                } else {
                    
                    arrForChange[i][0] = 0;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 1; j < m; j++) {
                
                if ((i + j) % 2 == 0) {
                    
                    if (arr[i][j].equals("W")) {
                        
                        arrForChange[i][j] = arrForChange[i][j - 1] + 1;
                    } else {
                        
                        arrForChange[i][j] = arrForChange[i][j - 1] + 0;
                    }
                } else {
                    
                    if (arr[i][j].equals("B")) {
                        
                        arrForChange[i][j] = arrForChange[i][j - 1] + 1;
                    } else {
                        
                        arrForChange[i][j] = arrForChange[i][j - 1] + 0;
                    }
                }
            }
        }
        
        int count = 32;
        
        for (int i = 0; i < n - 7; i++) {
            
            for (int j = 0; j < m - 7; j++) {
                
                int countIJ = 0;
                for (int i1 = i; i1 < i + 8; i1++) {
                    
                    if (j == 0) {
                        
                        countIJ += arrForChange[i1][j + 7];
                        continue;
                    }
                    countIJ += arrForChange[i1][j + 7] - arrForChange[i1][j - 1];
                }
                
                if (countIJ > 32) {
                    countIJ = 64 - countIJ;
                }
                
                if (countIJ < count) {
                    count = countIJ;
                }
            }
        }
        
        return String.valueOf(count);
    }
    
    public static void output(String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}