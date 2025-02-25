class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] queue = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            queue[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        int[] answer = new int[progresses.length];
        int count = 1;
        int max = queue[0];
        int idx = 0;

        for (int i = 1; i < queue.length; i++) {
            if (max >= queue[i]) {
                count++;
            } else {
                answer[idx++] = count;
                count = 1;
                max = queue[i];
            }
        }
        answer[idx++] = count;

        int[] newAnswer = new int[idx];
        System.arraycopy(answer, 0, newAnswer, 0, idx);

        return newAnswer;
    }
}