const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const t= Number(input[0]);
const twoNum = input.slice(1);

for(let i=0; i<t; i++) {
    let num = twoNum[i].split(' ').map(Number);
    console.log(num[0]+num[1]);
}