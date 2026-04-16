const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const sum = Number(input.shift(0));
const n = Number(input.shift(0));

let isSum = 0;
for(let i=0; i<n; i++) {
    let arr = input[i].split(' ').map(Number);
    isSum += arr[0]*arr[1];
}

console.log(isSum===sum ? "Yes" : "No");