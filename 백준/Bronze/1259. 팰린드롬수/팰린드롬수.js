const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

for(let i=0; i<input.length-1; i++) {
    let num = input[i].split('');
    let revNum = Array(num.length).fill(0);
    for(let j=0; j<num.length; j++) { revNum[j] = num[num.length-j-1]; }
    
    if(Number(num.join(''))-Number(revNum.join('')) === 0) console.log("yes");
    else console.log("no");
}