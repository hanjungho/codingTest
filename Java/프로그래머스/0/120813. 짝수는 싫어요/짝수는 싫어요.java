class Solution {
    public int[] solution(int n) {
        int maxIdx = n % 2 == 1 ? (n / 2) + 1 : n / 2;
        int[] answer = new int[maxIdx];
        for (int i = 0; i < maxIdx; i++) {
            answer[i] = (2 * i) + 1;
        }
        return answer;
    }
}