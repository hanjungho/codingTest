import java.util.*;
import java.io.*;

class User {
    int age;
    String name;
    
    User(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    @Override
    public String toString() {
        return age + " " + name;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static List<User> users;
    
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }
    
    public static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        users = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            users.add(new User(age, name));  // order 제거!
        }
    }
    
    public static String solve() {
        StringBuilder answer = new StringBuilder();
        
        // 나이로만 정렬 - 안정 정렬이라서 입력 순서 유지됨!
        users.sort((a, b) -> a.age - b.age);
        
        for (User user : users) {
            answer.append(user.toString()).append("\n");
        }
        
        return answer.toString();
    }
    
    public static void output(String outputStr) throws IOException {
        bw.write(outputStr);
        bw.flush();
        bw.close();
    }
}