import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        sb.append("    8888888888  888    88888\n   88     88   88 88   88  88\n    8888  88  88   88  88888\n       88 88 888888888 88   88\n88888888  88 88     88 88    888888\n\n88  88  88   888    88888    888888\n88  88  88  88 88   88  88  88\n88 8888 88 88   88  88888    8888\n 888  888 888888888 88  88      88\n  88  88  88     88 88   88888888");
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}