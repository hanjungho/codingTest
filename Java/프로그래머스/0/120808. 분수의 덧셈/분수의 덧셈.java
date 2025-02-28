class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int numer3 = (numer1 * denom2) + (numer2 * denom1);
        int denom3 = denom1 * denom2;
        
        int gcdNum = gcd(numer3, denom3);
        
        int[] answer = {numer3 / gcdNum, denom3 / gcdNum};
        return answer;
    }
    
    public int gcd (int num1, int num2) {
            if (num1 < num2) {
                int num3 = num1;
                num1 = num2;
                num2 = num3;
            };
            while (true) {
                int num3 = num1 % num2;
                if (num3 == 0) {
                    return num2;
                };
            num1 = num2;
            num2 = num3;
            }
    }
}
