const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const [n, m] = input[0].split(' ').map(Number);

console.log(Math.abs(n-m));