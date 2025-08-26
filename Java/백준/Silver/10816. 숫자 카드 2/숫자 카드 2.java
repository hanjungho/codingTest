import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    
    static int[] cards;
    
    static int[] quizCards;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        cards = new int[n];
        
        for (int i = 0; i < n; i++) {
            
            cards[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        
        quizCards = new int[m];
        
        for (int i = 0; i < m; i++) {
            
            quizCards[i] = Integer.parseInt(st.nextToken());
        }
        
        br.close();
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        Arrays.sort(cards);
        
        for (int i = 0; i < m; i++) {
            
            answer.append(String.valueOf(countByBinarySearch(quizCards[i]))).append(" ");
        }
        
        return answer.toString();
    }
    
    public static int countByBinarySearch(int value) {
        
        int lowerBound = findLowerBound(value);
        int upperBound = findUpperBound(value);
        
        if (lowerBound == n || cards[lowerBound] != value) {
            return 0;
        }
        
        return upperBound - lowerBound;
    }
    
    public static int findLowerBound(int value) {
        
        int left = 0;
        int right = n;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            
            if (cards[mid] < value) {
                
                left = mid + 1;
            } else {
                
                right = mid;
            }
        }
        
        return left;
    }
    
    public static int findUpperBound(int value) {
        
        int left = 0;
        int right = n;
        
        while (left < right) {
            
            int mid = (left + right) / 2;
            
            if (cards[mid] <= value) {
                
                left = mid + 1;
            } else {
                
                right = mid;
            }
        }
        
        return left;
    }
    
    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
