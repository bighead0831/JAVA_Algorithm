const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const n = input.slice(1).map(Number);

let arr = []; // dynamic array

for(let i=0; i<n.length; i++) {
    if(n[i] === 0) arr.pop();
    else arr.push(n[i]);
}

let sum = 0;
for(let i=0; i<arr.length; i++) sum += arr[i];

console.log(sum);