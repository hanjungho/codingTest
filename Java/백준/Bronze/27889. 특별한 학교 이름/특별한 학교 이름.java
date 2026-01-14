import java.io.*;
import java.util.*;

public class Main {
    
    static String str;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    // NLCS: North London Collegiate School
    // BHA: Branksome Hall Asia
    // KIS: Korea International School
    // SJA: St. Johnsbury Academy

    public static void input(BufferedReader br) throws IOException {
        
        str = br.readLine();
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        if (str.equals("NLCS")) {
            
            return "North London Collegiate School";
        } else if (str.equals("BHA")) {
            
            return "Branksome Hall Asia";
        } else if (str.equals("KIS")) {
            
            return "Korea International School";
        } else if (str.equals("SJA")) {
            
            return "St. Johnsbury Academy";
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
        bw.close();
    }
}