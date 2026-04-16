const fs = require("fs");

let s = fs.readFileSync(0).toString().trim(); // 문자열(String) 입력

let check = "abcdefghijklmnopqrstuvwxyz"; // 알파벳 검사

let result = ''; // 결과

for(let i=0; i<check.length; i++) {
    let tmpr = -1;
    for(let j=0; j<s.length; j++) {
        if(check[i] == s[j]) {
            tmpr = j;
            result += tmpr + ' ';
            break;
        }
        if(j == (s.length-1) && tmpr == -1) {
            result += tmpr + ' ';
            break;
        }
    }
}

console.log(result);