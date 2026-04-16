const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);
const nums = input[1].split('').map(Number);

let sum = 0;
for(let i=0; i<n; i++) {sum += nums[i]}
console.log(sum);