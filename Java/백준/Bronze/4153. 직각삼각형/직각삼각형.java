import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (;;) {
            String lengths = bufferedReader.readLine();
            int[] s = Arrays.stream(lengths.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            Arrays.sort(s);
            int a = s[0];
            int b = s[1];
            int c = s[2];
            if (a == 0 && b == 0 && c == 0) {
                break;
            }
            if (a*a + b*b == c*c) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}