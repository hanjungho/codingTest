import java.io.*;
import java.util.*;

public class Main {
    
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            bw.write("고려대학교");
            bw.flush();
        }
    }
}