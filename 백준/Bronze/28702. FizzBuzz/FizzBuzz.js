const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const arr = input.slice(0, 3);

let justNum = 0;
for(let i=0; i<3; i++) {
    if(arr[i] != 'Fizz' && arr[i] != 'Buzz' && arr[i] != 'FizzBuzz') justNum = i;
}

let result = 0;
if(justNum===0) result = Number(arr[justNum])+3;
else if(justNum===1) result = Number(arr[justNum])+2;
else result = Number(arr[justNum])+1;

if(result%3 === 0 && result%5 === 0) console.log("FizzBuzz");
else if(result%3 === 0 && result%5 != 0) console.log("Fizz");
else if(result%3 != 0 && result%5 === 0) console.log("Buzz");
else console.log(result);