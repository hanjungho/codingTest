import java.util.*;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int centerIdx = array.length / 2;
        int answer = array[centerIdx];
        return answer;
    }
}