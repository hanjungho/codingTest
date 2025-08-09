import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int s;
    static int p;
    
    static String DNAStr;
    
    static final String[] DNA_CHAR = {"A", "C", "G", "T"};
    static int[] minNum = new int[4];
    
    public static void main(String[] args) throws IOException {
        
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        DNAStr = st.nextToken();
        
        st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < 4; i++) {
            minNum[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }
    
    public static String solve() {
        
        int count = 0;
        
        int[] DNACount = {0, 0, 0, 0};
        
        String[] DNAStrArr = DNAStr.split("");
        
        for (int i = 0; i < p; i++) {
            if (DNAStrArr[i].equals("A")) {
                DNACount[0]++;
            } else if (DNAStrArr[i].equals("C")) {
                DNACount[1]++;
            } else if (DNAStrArr[i].equals("G")) {
                DNACount[2]++;
            } else {
                DNACount[3]++;
            }
        }
        
        for (int i = 0; i < s - p + 1; i++) {
            if (DNACount[0] >= minNum[0] && DNACount[1] >= minNum[1] && DNACount[2] >= minNum[2] && DNACount[3] >= minNum[3]) {
                count++;
            }
            if (i < s - p) {
                if (DNAStrArr[i].equals("A")) {
                    DNACount[0]--;
                } else if (DNAStrArr[i].equals("C")) {
                    DNACount[1]--;
                } else if (DNAStrArr[i].equals("G")) {
                    DNACount[2]--;
                } else {
                    DNACount[3]--;
                }
                
                if (DNAStrArr[i + p].equals("A")) {
                    DNACount[0]++;
                } else if (DNAStrArr[i + p].equals("C")) {
                    DNACount[1]++;
                } else if (DNAStrArr[i + p].equals("G")) {
                    DNACount[2]++;
                } else {
                    DNACount[3]++;
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