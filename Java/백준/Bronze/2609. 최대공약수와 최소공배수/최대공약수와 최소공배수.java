import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        if (a < b) {
            int c;
            c = a;
            a = b;
            b = c;
        }
        int bigNum = a;
        int smallNum = b;
        while (true) {
            int c = bigNum % smallNum;
            if (c == 0) {
                System.out.println(smallNum + "\n" + a * b / smallNum);
                break;
            }
            bigNum = smallNum;
            smallNum = c;
        }
    }
}