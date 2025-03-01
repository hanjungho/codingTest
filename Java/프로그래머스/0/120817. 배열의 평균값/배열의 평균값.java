class Solution {
    public double solution(int[] numbers) {
        int total = 0;
        for (int num : numbers) {
            total += num;
        }
        double answer = (double) total / numbers.length;
        return answer;
    }
}