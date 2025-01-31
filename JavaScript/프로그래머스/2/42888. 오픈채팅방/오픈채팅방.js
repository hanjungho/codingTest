function solution(record) {
    const obj = new Map();
    const msg = [];
    for (const i of record) {
        const a = i.split(' ');
        if (a[0] === "Enter") {
            obj[a[1]] = a[2];
        } else if (a[0] === "Change") {
            obj[a[1]] = a[2];
        }
    }
    
    for (const i of record) {
        const a = i.split(' ');
        if (a[0] === "Enter") {
            msg.push(`${obj[a[1]]}님이 들어왔습니다.`);
        } else if (a[0] === "Leave") {
            msg.push(`${obj[a[1]]}님이 나갔습니다.`);
        }
    }
    
    return msg;
}
