const fs = require("fs");
const arr = fs.readFileSync(0).toString().trim().split('\n').map(Number);

let maxNum = 0;
let maxPosition = 0;
for(let i=0; i<arr.length; i++) {
    maxNum = Math.max(maxNum, arr[i]);
    if(maxNum === arr[i]) maxPosition = i+1;
}

console.log(maxNum+'\n'+maxPosition);