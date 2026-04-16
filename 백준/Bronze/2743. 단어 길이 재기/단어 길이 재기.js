const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const word = input[0].split('');
console.log(word.length);