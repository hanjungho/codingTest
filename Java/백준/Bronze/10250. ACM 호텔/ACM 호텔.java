import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < t; i++) {
            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int n = scanner.nextInt();

            int floor = (n % h == 0) ? h : (n % h);
            int room = (n - 1) / h + 1;

            System.out.printf("%d%02d\n", floor, room);
        }
    }
}