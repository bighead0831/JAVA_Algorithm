const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let [x, y] = [input[0], input[1]];

let quardrant = 0;

if(x>0 && y>0) {quardrant = 1;}
else if(x<0 && y>0) {quardrant = 2;}
else if(x<0 && y<0) {quardrant = 3;}
else if(x>0 && y<0) {quardrant = 4;}

console.log(quardrant);