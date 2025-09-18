import java.util.*;
import java.io.*;

class Wear {
    
    String name;
    String type;
    
    Wear (String name, String type) {
        
        this.name = name;
        this.type = type;
    }
}

class TestCase {
    
    int numOfWears;
    Wear[] wears;
    
    TestCase (int numOfWears, Wear[] wears) {
        
        this.numOfWears = numOfWears;
        this.wears = wears;
    }
}

public class Main {
    
    static int numOfTestCase;
    
    static TestCase[] testCases;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        numOfTestCase = Integer.parseInt(br.readLine());
        
        testCases = new TestCase[numOfTestCase];
        
        for (int i = 0; i < numOfTestCase; i++) {
            
            int n = Integer.parseInt(br.readLine());
            
            Wear[] wears = new Wear[n];
            
            for (int j = 0; j < n; j++) {
                
                StringTokenizer st = new StringTokenizer(br.readLine());
                
                Wear wear= new Wear(st.nextToken(), st.nextToken());
                
                wears[j] = wear;
            }
            
            TestCase testCase = new TestCase(n, wears);
            
            testCases[i] = testCase;
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < numOfTestCase; i++) {
            
            Map<String, Integer> cntType = new HashMap<>();
            
            TestCase testCase = testCases[i];
            
            int numOfWaers = testCase.numOfWears;
            Wear[] wears = testCase.wears;
            
            for (int j = 0; j < numOfWaers; j++) {
                
                Wear wear = wears[j];
                
                if (cntType.get(wear.type) == null) {
                    
                    cntType.put(wear.type, 1);
                } else {
                    
                    cntType.put(wear.type, cntType.get(wear.type) + 1);
                }
            }
            
            final int[] result = {1};
            
            cntType.forEach((type, cnt) -> {
                
                result[0] *= cnt + 1;
            });
            
            result[0]--;
            
            sb.append(String.valueOf(result[0])).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}