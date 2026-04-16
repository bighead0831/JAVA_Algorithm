const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const [N, M] = input[0].split(' ').map(Number);
const cards = input[1].split(' ').map(Number);

let maxSum = 0;
for(let i=0; i<N; i++) {
    for(let j=i+1; j<N; j++) {
        for(let k=j+1; k<N; k++) {
            let tmpSum = cards[i]+cards[j]+cards[k];
            if(tmpSum<=M) maxSum = Math.max(maxSum, tmpSum);
        }
    }
}

console.log(maxSum);