const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n').map(Number);

for(let i=1; i<=9; i++) {
    console.log(input[0]+' * '+i+' = '+input[0]*i);
}