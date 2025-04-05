import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputNum = input.split(" ");
        String result;
        int pre = -1;
        int interval = 0;
        if (Objects.equals(inputNum[0], "1")) {
            pre = 0;
            interval = 1;
            result = "ascending";
        } else if (Objects.equals(inputNum[0], "8")) {
            pre = 9;
            interval = -1;
            result = "descending";
        } else {
            result = "mixed";
        }
        if (pre != -1) {
            for (String s : inputNum) {
                int a = Integer.parseInt(s);
                if (interval != a - pre) {
                    result = "mixed";
                    break;
                }
                pre = a;
            }
        }
        System.out.println(result);
    }
}