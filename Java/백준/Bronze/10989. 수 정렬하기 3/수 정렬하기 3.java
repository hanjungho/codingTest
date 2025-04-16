import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
        }

        bufferedReader.close();

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            bufferedWriter.write(String.valueOf(arr[i]));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}