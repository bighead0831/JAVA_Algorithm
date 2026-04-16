const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

let elements = [];
for(let i=0; i<input.length-1; i++) {
    elements.push(input[i].split(' ').map(Number));
}

function isRight(bigNum, l1, l2) {
    return bigNum**2 === l1**2+l2**2;
}

for(let i=0; i<elements.length; i++) {
    const a = elements[i][0];
    const b = elements[i][1];
    const c = elements[i][2];
    
    if(a>b && a>c) {
        if(isRight(a, b, c)) console.log("right");
        else console.log("wrong");
    } else if(b>a && b>c) {
        if(isRight(b, c, a)) console.log("right");
        else console.log("wrong");
    } else if(c>a && c>b) {
        if(isRight(c, a, b)) console.log("right");
        else console.log("wrong");
    }
}