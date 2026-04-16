const fs = require("fs");

let m = Number(fs.readFileSync(0).toString().trim()); // 배달할 설탕 무게 입력

let result = []; // 최소 설탕봉지 갯수 초기화
let rcnt = 0;

let realResult = 0;

for (let i=0; i<=parseInt(m/5); i++) {
    let cnt = i; // 5키로 설탕봉지 갯수를 일단 카운트에 포함
    
    if (m == i*5) { // 5키로 봉지만으로도 조건이 충족되었을 때도 result에 저장
        result[rcnt] = cnt;
        rcnt++;
        break;
    } else {
        for (let j=0; j<=parseInt((m-i*5)/3); j++) {
            if (m == 5*i+3*j) { // 입력한 설탕무게와 정확히 일치하면
                cnt += j; // 기존 포함한 5키로 설탕봉지 갯수에 3키로 설탕봉지 갯수 덧셈
            }
        }
        if (cnt > i) { // 5키로 봉지와 3키로 봉지 갯수의 합 result에 저장
            result[rcnt] = cnt;
            rcnt++;
        }
    }
}

if(rcnt == 0) { // 설탕 무게 입력값 만큼 봉지로 옮길 수 없으면 '-1' 출력
    realResult = -1;
} else if(rcnt == 1) { // 봉지갯수 케이스가 한 개일 경우 바로 출력
    realResult = Number(result[0]);
} else { // 봉지 갯수 케이스가 여러 개일 경우 비교하여 작은 것을 출력
    let tmp = result[rcnt-1];
    for(let k=0; k<rcnt; k++) {
        if(Number(result[k]) <= tmp) {
            realResult = Number(result[k])
            tmp = realResult;
        }
    }
}

console.log(realResult);