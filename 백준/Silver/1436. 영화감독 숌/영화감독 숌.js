const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split("\n");

const n = Number(input[0]); // 입력값
let num = 666; // 가장 작은 666 포함된 숫자

let cnt = 1; // 1부터 카운트
while(1) {
    if(n === 1) break; // 1이 입력되면 바로 break;

    num++; // 2이상 입력되면 num 1씩 증가하면서 검사
    if(String(num).includes("666")) cnt++; // 오름차순으로 숫자에 666이 포함되는지 확인하고 포함되면 cnt 증가

    if(cnt === n) break; // 입력된 값과 cnt값이 같으면 그때의 num값을 결과값으로 출력
}

console.log(num); // 결과값 출력