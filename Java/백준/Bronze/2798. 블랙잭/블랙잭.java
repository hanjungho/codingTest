import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] cards = new int[n];

        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int maxValue = 0;
        for (int i = 0; i < cards.length - 2; i++) {
            int card1 = cards[i];
            for (int j = i + 1; j < cards.length - 1; j++) {
                int card2 = cards[j];
                for (int k = j + 1; k < cards.length; k++) {
                    int card3 = cards[k];
                    int value = card1 + card2 + card3;
                    if (maxValue < value && value <= m) {
                        maxValue = value;
                    }
                }
            }
        }
        System.out.println(maxValue);
    }
}