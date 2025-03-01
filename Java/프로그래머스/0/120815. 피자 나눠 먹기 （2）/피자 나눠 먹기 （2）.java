class Solution {
    public int solution(int n) {
        int answer = n;
        if (answer % 3 == 0) {
            answer /= 3;
        }
        if (answer % 2 == 0) {
            answer /= 2;
        }
        return answer;
    }
}