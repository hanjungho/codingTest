import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for(int i = 0 ; i < N ; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0 ; j < N ; j ++) {
                board[i][j] = input[j];
            }
        }
        countPaper(N, board);
        System.out.println(white);
        System.out.println(blue);
    }
    //색종이 확인
    public static boolean isSameColor(int color, int N, int[][] board) {
       for(int i = 0 ; i < N * N ; i ++) {
           int x = i / N;
           int y = i % N;
           int curr = board[x][y];
           if(color!=curr) {
               return false;
           }
       }
       return true;
    }

    public static void countPaper(int N, int[][] board) {
        int color = board[0][0];
        if(N==1||isSameColor(color, N, board)) {
            if(color==0) {
                white++;
                return;
            }
            blue++;
        }else {
            int size = N / 2;
            int[] dx = {0, N/2,  0, N/2 };
            int[] dy = {0, 0, N/2, N/2};
            for(int i = 0 ; i < 4 ; i ++) {
                int[][] arr = new int[size][size];
                int nx = 0 + dx[i];
                int ny = 0 + dy[i];
                for(int m = 0 ; m < size ; m ++) {
                    for(int n = 0 ; n < size ; n++) {
                        arr[m][n] = board[m+nx][n+ny];
                    }
                }
                countPaper(size,arr);
            }
        }
    }
}