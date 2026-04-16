const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);
const words = input.slice(1, n+1);

words.sort(); // 사전순 정렬
words.sort(function(a,b){return a.length-b.length;}); // 길이순 정렬

for(let i=0; i<n; i++) {
    if(i===0) console.log(words[i]);
    if(i>=1 && words[i-1] != words[i]) // 중복단어는 미출력
        console.log(words[i]);
}