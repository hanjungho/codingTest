class Solution {
    public int solution(int slice, int n) {
        int answer = (int) Math.ceil(n / (double) slice);
        return answer;
    }
}