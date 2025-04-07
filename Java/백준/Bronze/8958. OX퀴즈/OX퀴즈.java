import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt((scanner.nextLine()));

        for (int i = 0; i < num; i++) {
            String testCase = scanner.nextLine();
            int point = 0;
            int totalPoint = 0;
            for (char c : testCase.toCharArray()) {
                if (c == 'O') {
                    point++;
                    totalPoint += point;
                } else {
                    point = 0;
                }
            }
            System.out.println(totalPoint);
        }

    }
}