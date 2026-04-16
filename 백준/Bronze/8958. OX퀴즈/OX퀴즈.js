const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const n = Number(input[0]);
const solved = input.slice(1, n+1);



for(let i=0; i<n; i++) {
    let arr = Array(solved[i].length).fill('');
    for(let j=0; j<arr.length; j++) {
        arr[j] = solved[i][j];
    }

    let score = 0;
    let sum = 0;
    for(let j=0; j<arr.length; j++) {
        if(arr[j] == 'O') {
            score++;
            sum += score;
        } else {
            score = 0;
        }
    }
    console.log(sum);
    
}