import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int t;
    static int n;
    static int[] aArr;
    static int m;
    static int[] bArr;
    
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        t = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        
        aArr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            aArr[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        
        bArr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }
    }
    
    public static String solve() {
        StringBuilder answer = new StringBuilder();
        
        // 누적합 배열 생성
        int[] aCumSumArr = new int[n];
        aCumSumArr[0] = aArr[0];
        
        int[] bCumSumArr = new int[m];
        bCumSumArr[0] = bArr[0];
        
        for (int i = 1; i < n; i++) {
            aCumSumArr[i] = aCumSumArr[i - 1] + aArr[i];
        }
        
        for (int i = 1; i < m; i++) {
            bCumSumArr[i] = bCumSumArr[i - 1] + bArr[i];
        }
        
        // A 배열의 모든 부분 배열 합을 리스트에 저장
        List<Integer> aList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == 0) {
                    aList.add(aCumSumArr[j]);
                } else {
                    aList.add(aCumSumArr[j] - aCumSumArr[i-1]);
                }
            }
        }
        
        // B 배열의 모든 부분 배열 합을 HashMap에 저장 (개수와 함께)
        Map<Integer, Integer> bMap = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int sum;
                if (i == 0) {
                    sum = bCumSumArr[j];
                } else {
                    sum = bCumSumArr[j] - bCumSumArr[i-1];
                }
                bMap.put(sum, bMap.getOrDefault(sum, 0) + 1);
            }
        }
        
        // A의 각 부분 배열 합에 대해 (T - A의 합)이 B에 몇 개 있는지 확인
        long count = 0;
        for (int aSum : aList) {
            int target = t - aSum;
            count += bMap.getOrDefault(target, 0);
        }
        
        answer.append(String.valueOf(count));
        return answer.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        bw.write(outputStr);
        bw.flush();
        bw.close();
    }
}