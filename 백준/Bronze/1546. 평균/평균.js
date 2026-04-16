const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);
const scores = input[1].split(' ').map(Number);

let M = 0;
for(let i=0; i<n; i++) {
    M = Math.max(M, scores[i]);
}

let sum = 0;
for(let i=0; i<n; i++) {
   sum += scores[i]/M*100;
}

console.log(sum/n);