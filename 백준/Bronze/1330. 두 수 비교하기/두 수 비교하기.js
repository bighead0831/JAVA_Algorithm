const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let [a, b] = input[0].split(' ').map(Number);

let result = '';
if(a>b) {
    result = '>';
} else if(a<b) {
    result = '<';
} else if(a===b) {
    result = '==';
}

console.log(result);