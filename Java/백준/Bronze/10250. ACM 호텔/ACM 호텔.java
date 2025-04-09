import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt((scanner.nextLine()));

        for (int i = 0; i < num; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();

            if (n % h == 0) {
                System.out.println(h * 100 + (n / h));
            } else {
                System.out.println((n / h) + 1 + (n % h) * 100);
            }
        }

    }
}