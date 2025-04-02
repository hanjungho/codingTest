import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int[] countArray = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        String result = String.valueOf(a * b * c);
        for (int i = 0; i < result.length(); i++) {
            int i1 = (result.charAt(i)) - '0';
            countArray[i1]++;
        }

        for (int i : countArray) {
            System.out.println(i);
        }
    }
}