const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const str = input[0].split('');
const n = Number(input[1]);

console.log(str[n-1]);