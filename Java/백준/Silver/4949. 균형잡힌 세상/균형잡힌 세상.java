import java.util.*;
import java.io.*;

public class Main {
    
    static Deque<String> sentences = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        while(true) {
            
            String sentence = br.readLine();
            
            if (sentence.equals(".")) {
                break;
            }
            
            sentences.addLast(sentence);
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        while (!sentences.isEmpty()) {
            
            String sentence = sentences.removeFirst();
            
            sb.append(String.valueOf(validateSentence(sentence))).append("\n");
        }
        
        return sb.toString();
    }
    
    public static String validateSentence(String sentence) {
        
        Deque<String> dq = new ArrayDeque<>();
        
        String[] sentenceArr = sentence.split("");
        
        int sentenceLength = sentenceArr.length;
        
        for (int i = 0; i < sentenceLength; i++) {
            
            if (sentenceArr[i].equals("(")) {
                
                dq.addLast("(");
            } else if (sentenceArr[i].equals("[")) {
                
                dq.addLast("[");
            } else if (sentenceArr[i].equals(")")) {
                
                if (dq.isEmpty()) {
                    
                    return "no";
                }
                
                String str = dq.removeLast();
                
                if (!str.equals("(")) {
                    
                    return "no";
                }
            } else if (sentenceArr[i].equals("]")) {
                
                if (dq.isEmpty()) {
                    
                    return "no";
                }
                
                String str = dq.removeLast();
                
                if (!str.equals("[")) {
                    
                    return "no";
                }
            }
        }
        
        if (dq.isEmpty()) {
            
            return "yes";
        } else {
            
            return "no";
        }
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}