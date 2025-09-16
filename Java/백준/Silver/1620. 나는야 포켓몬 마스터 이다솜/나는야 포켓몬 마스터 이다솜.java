import java.util.*;
import java.io.*;
public class Main {
    
    static int n;
    
    static int m;
    
    static String[] pokemons;
    
    static String[] quizs;
    
    public static void main(String[] args) throws IOException {
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            input(br);
            output(bw, solve());
        }
    }
    
    public static void input(BufferedReader br) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        
        m = Integer.parseInt(st.nextToken());
        
        pokemons = new String[n];
        
        for (int i = 0; i < n; i++) {
            
            pokemons[i] = br.readLine();
        }
        
        quizs = new String[m];
        
        for (int i = 0; i < m; i++) {
            
            quizs[i] = br.readLine();
        }
    }
    
    public static String solve() {
        
        StringBuilder sb = new StringBuilder();
        
        Map<String, Integer> pokemonsHashMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            
            pokemonsHashMap.put(pokemons[i], i + 1);
        }
        
        for (int i = 0; i < m; i++) {
            
            String[] quiz = quizs[i].split("");
            String firstStr = quiz[0];
            
            boolean isNum = false;
            
            for (int j = 1; j < 10; j++) {
                
                if (firstStr.equals(String.valueOf(j))) {
                    
                    sb.append(pokemons[Integer.parseInt(quizs[i]) - 1]);
                    
                    isNum = true;
                    break;
                }
            }
            
            if (!isNum) {
                
                sb.append(String.valueOf(pokemonsHashMap.get(quizs[i])));
            }
            
            sb.append("\n");
        }
        
        return sb.toString();
    }
    
    public static void output(BufferedWriter bw, String outputStr) throws IOException {
        
        bw.write(outputStr);
        
        bw.flush();
    }
}