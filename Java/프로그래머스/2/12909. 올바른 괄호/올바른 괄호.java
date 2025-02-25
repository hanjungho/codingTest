import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        
        boolean answer = true;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                deque.push(c);
            } else {
                if (deque.isEmpty()) {
                    answer = false;
                    break;
                }
                deque.pop();
            }
        }
        
        if (deque.isEmpty() == false) {
            answer = false;
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}