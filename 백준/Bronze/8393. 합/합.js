const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const num = Number(input[0]);

let n = 1;
let result = 0;
for(let i=0; i<num; i++) {
    result += n;
    n++;
}
console.log(result);