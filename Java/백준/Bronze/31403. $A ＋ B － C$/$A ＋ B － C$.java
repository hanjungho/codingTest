import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        System.out.println(a + b - c);

        System.out.println(Integer.parseInt(String.valueOf(a) + String.valueOf(b)) - c);
    }
}