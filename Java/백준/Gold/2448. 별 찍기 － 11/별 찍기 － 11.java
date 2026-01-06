import java.io.*;
import java.util.*;

public class Main {
    
    static int n;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        n = Integer.parseInt(br.readLine());
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        String[] stars = new String[3];
        
        stars[0] = "  *  ";
        stars[1] = " * * ";
        stars[2] = "*****";
        
        sb.append(draw(stars));
        
        return sb.toString();
    }
    
    public static String draw(String[] stars) {
        
        int cntN = stars.length;
        
        StringBuilder sb = new StringBuilder();
        
        if (cntN == n) {
            
            for (int i = 0; i < cntN; i++) {
                
                sb.append(stars[i]).append(" ").append("\n");
            }
            
            return sb.toString();
        }
        
        String[] newStars = new String[cntN * 2];
        
        for (int i = 0; i < cntN; i++) {
            
            sb = new StringBuilder();
            
            for (int j = 0; j < cntN; j++) {
                
                sb.append(" ");
            }
            
            sb.append(stars[i]);
            
            for (int j = 0; j < cntN; j++) {
                
                sb.append(" ");
            }
            
            newStars[i] = sb.toString();
        }
        
        for (int i = 0; i < cntN; i++) {
            
            sb = new StringBuilder();
            
            sb.append(stars[i]).append(" ").append(stars[i]);
            
            newStars[cntN + i] = sb.toString();
        }
        
        return draw(newStars);
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}