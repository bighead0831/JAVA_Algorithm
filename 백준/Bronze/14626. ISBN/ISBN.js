const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let arr = Array(13).fill(0);
arr = input[0].split('');

let sum = 0;
let x = 1;
for(let i=0; i<13; i++) {
    if(arr[i] != '*') {
        if((i+1)%2 === 0) sum += Number(arr[i])*3;
        else sum += Number(arr[i]);   
    } else {
        if((i+1)%2 === 0) x = 3;
        else x = 1; 
    }
}

let result = 0;
for(let i=1; i<=9; i++) {
    if((sum+i*x)%10 === 0) result = i;
}
console.log(result);