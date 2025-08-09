import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int m;
    static int[][] edgeArr;
    static int[] unionFindArr;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(st.nextToken());
        
        edgeArr = new int[m * 2][2];
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            
            int firstNode = Integer.parseInt(st.nextToken());
        
            int secondNode = Integer.parseInt(st.nextToken());
            
            edgeArr[(2 * i)][0] = firstNode;
            edgeArr[(2 * i)][1] = secondNode;
            edgeArr[(2 * i) + 1][0] = firstNode;
            edgeArr[(2 * i) + 1][1] = secondNode;
        }
        
        unionFindArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            unionFindArr[i] = i + 1;
        }
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < m * 2; i++) {
            
            union(edgeArr[i][0], edgeArr[i][1]);
        }
        
        int[] countArr = new int[n];
        
        for (int i = 0; i < n; i++) {
            countArr[i] = 0;
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            
            if (countArr[find(i + 1) - 1] == 0) {
                count++;
            }
            countArr[find(i + 1) - 1]++;
        }
        
        answer.append(String.valueOf(count));
        
        return answer.toString();
    }
    
    public static int find(int node) {
        
        if (unionFindArr[node - 1] == node) {
            return node;
        } else {
            return find(unionFindArr[node - 1]);
        }
    }
    
    public static void union(int startNode, int endNode) {
        
        int rootA = find(startNode);
        int rootB = find(endNode);
    
        if (rootA != rootB) {
            if (rootA < rootB) {
                unionFindArr[rootB - 1] = rootA;
            } else {
                unionFindArr[rootA - 1] = rootB;
           }
        }
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
