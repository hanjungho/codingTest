import java.util.*;
import java.io.*;

public class Main {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N;
    static String[] words;
    
    public static void main(String[] args) throws Exception {
        
        inputData();
        findAnswer();
        
        for (int i = 0; i < N; i++) {
            if (i > 0 && words[i].equals(words[i - 1])) {
                continue;
            }
            bw.write(words[i]);
            bw.newLine();
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
    
    public static void inputData() throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        
        words = new String[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            words[i] = st.nextToken();
        }
    }
    
    public static void findAnswer() {
        
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if (s1.length() != s2.length()) {
                    return s1.length() - s2.length();
                } else {
                    return s1.compareTo(s2);
                }
            }
        });
        
    }
}