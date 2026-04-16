const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);
const arr = input[1].split(' ').map(Number);
const v = Number(input[2]);

let cnt = 0;
for(let i=0; i<n; i++)
    cnt += arr[i]===v ? 1 : 0;
console.log(cnt);