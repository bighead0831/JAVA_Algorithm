const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = input[0].split(' ').map(Number);

let sum = 0;
for(let i=0; i<n.length; i++) {
    sum += n[i]**2;
}
console.log(sum%10);