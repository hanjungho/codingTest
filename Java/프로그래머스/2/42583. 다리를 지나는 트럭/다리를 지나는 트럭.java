import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int truckNum = truck_weights.length;
        Deque<Integer> waitDeque = new ArrayDeque<>();
        Deque<Integer[]> crossingDeque = new ArrayDeque<>();
        Deque<Integer> crossedDeque = new ArrayDeque<>();
        for (int weights : truck_weights) {
            waitDeque.offer(weights);
        }
        while (true) {
            
            if (crossedDeque.size() == truckNum) {
                break;
            }
            answer++;
            
            int count = 0;
            for (Integer[] truck : crossingDeque) {
                truck[1]++;
                if (truck[1] == bridge_length) {
                    count++;
                }
            }
            for (int i = 0; i < count; i++) {
                crossedDeque.push(crossingDeque.poll()[0]);
            }
            if (waitDeque.isEmpty() == false) {
                int total = 0;
                for (Integer[] truck : crossingDeque) {
                    total += truck[0];
                }
                if (waitDeque.peekFirst() + total <= weight) {
                    crossingDeque.offer(new Integer[] {waitDeque.poll(), 0});
                }
            }
        }
        return answer;
    }
}