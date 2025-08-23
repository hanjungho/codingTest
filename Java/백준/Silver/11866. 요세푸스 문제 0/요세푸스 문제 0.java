import java.util.*;
import java.io.*;

class Node {
    
    int value;
    Node nextNode;
    
    Node(int value, Node nextNode) {
        
        this.value = value;
        this.nextNode = nextNode;
    }
    
    void changeNextNode(Node newNextNode) {
        
        this.nextNode = newNextNode;
    }
    
    Node moveForward(int numToMove) {
        
        if (numToMove == 0) {
            
            return this;
        }
        
        if (this.nextNode == null) {
            
            return this;
        }
        
        Node currentNode = this.nextNode;
        
        for (int i = 1; i < numToMove; i++) {
            
            if (currentNode.nextNode == null) {
                
                return currentNode;
            }
            
            currentNode = currentNode.nextNode;
        }
        
        return currentNode;
    }
}

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n;
    static int k;
    
    public static void main(String[] args) throws IOException {

        input();
        output(solve());
    }

    public static void input() throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        
        k = Integer.parseInt(st.nextToken());
        
        br.close();
    }

    public static String solve() {

        StringBuilder answer = new StringBuilder();

        Node firstNode = new Node(1, null);
        
        Node currentNode = firstNode;
        
        for (int i = 2; i < n + 1; i++) {
            
            Node nextNode = new Node(i, null);
            
            currentNode.changeNextNode(nextNode);
            
            currentNode = nextNode;
        }
        
        currentNode.changeNextNode(firstNode);
        
        answer.append("<");
        
        while(true) {
            
            if (currentNode.nextNode == currentNode) {
                
                answer.append(String.valueOf(currentNode.value)).append(">");
                break;
            }
            
            currentNode = currentNode.moveForward(k - 1);
            
            answer.append(String.valueOf(currentNode.nextNode.value)).append(", ");
            
            currentNode.changeNextNode(currentNode.nextNode.nextNode);
            
        }
        
        return answer.toString();
    }

    public static void output(String outputStr) throws IOException {

        bw.write(outputStr);

        bw.flush();
        bw.close();
    }
}
