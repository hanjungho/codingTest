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

        return answer;
    }
}