const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);

let factorial = 1;
for(let i=1; i<=n; i++) {
    factorial *= i;
}
console.log(factorial);