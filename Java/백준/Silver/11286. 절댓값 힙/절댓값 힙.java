import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    
    static int[] inputArr;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        inputArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            st = new StringTokenizer(br.readLine());
        
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();
        
        // PriorityQueue로 변경: 절댓값 기준 최소힙, 같으면 실제값 기준 오름차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> 
            Math.abs(a) == Math.abs(b) ? a - b : Math.abs(a) - Math.abs(b)
        );
        
        for (int i = 0; i < n; i++) {
            
            int curNum = inputArr[i];
            
            if (curNum == 0) {
                if (!pq.isEmpty()) {
                    int removedNum = pq.poll(); // 최솟값 제거
                    answer.append(String.valueOf(removedNum) + "\n");
                } else {
                    answer.append("0" + "\n");
                }
                
            } else {
                pq.offer(curNum); // 힙에 추가 (자동으로 정렬됨)
            }
        }
        return answer.toString();
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
