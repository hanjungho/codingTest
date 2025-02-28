import java.util.*;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> numberCount = new LinkedHashMap<>();
        for (int num : array) {
            if (numberCount.containsKey(num)) {
                numberCount.put(num, numberCount.get(num) + 1);
            } else {
                numberCount.put(num, 1);
            }
        }
        int maxCountKey = -1;
        int maxCountValue = 0;
        boolean manyMode = false;
        
        for (Map.Entry<Integer, Integer> entry : numberCount.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value > maxCountValue) {
                maxCountValue = value;
                maxCountKey = key;
                manyMode = false;
            } else if (value == maxCountValue) {
                manyMode = true;
            }
        }
        
        if (manyMode) {
            return -1;
        } else {
            return maxCountKey;
        }
    }
}