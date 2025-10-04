import java.util.*;
import java.io.*;

class Child {
    
    String c1;
    String c2;
    
    Child(String c1, String c2) {
        
        this.c1 = c1;
        this.c2 = c2;
    }
}

public class Main {
    
    static int n;
    static Map<String, Child> inputMap = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            String parent = st.nextToken();
            String c1 = st.nextToken();
            String c2 = st.nextToken();
            
            inputMap.put(parent, new Child(c1, c2));
        }
    }
    
    public static String solve() {
        
        preOrder("A");
        sb.append("\n");
        inOrder("A");
        sb.append("\n");
        postOrder("A");
        
        return sb.toString();
    }
    
    public static void preOrder(String node) {
        
        if (node.equals(".")) return;
        
        sb.append(node);
        
        Child c = inputMap.get(node);
        if (c != null) {
            preOrder(c.c1);
            preOrder(c.c2);
        }
    }
    
    public static void inOrder(String node) {
        
        if (node.equals(".")) return;
        
        Child c = inputMap.get(node);
        if (c != null) {
            inOrder(c.c1);
            sb.append(node);
            inOrder(c.c2);
        }
    }
    
    public static void postOrder(String node) {
        
        if (node.equals(".")) return;
        
        Child c = inputMap.get(node);
        if (c != null) {
            postOrder(c.c1);
            postOrder(c.c2);
            sb.append(node);
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        bw.flush();
    }
}