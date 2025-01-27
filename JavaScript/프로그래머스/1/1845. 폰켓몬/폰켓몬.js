function solution(nums) {
    const arr = [];
    for (i of nums) {
        if (!(arr.includes(i))) {
            arr.push(i);
        }
    }
    a = nums.length / 2;
    b = arr.length;

    return Math.min(a, b);
}