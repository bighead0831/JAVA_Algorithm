const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let year = Number(input[0]);

let result = 0;
if(year%4 == 0) {
    if(year%400 != 0 && year%100 == 0) {
        result = 0;
    } else {
        result = 1;
    }
}

console.log(result);