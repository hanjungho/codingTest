class Solution {
    public int[] solution(int[] num_list) {
        int listLength = num_list.length;
        int[] answer = new int[listLength];
        for (int i = 0; i < listLength; i++) {
            answer[i] = num_list[listLength - i - 1];
        }
        return answer;
    }
}