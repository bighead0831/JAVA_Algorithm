const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');

const [h, m] = input[0].split(' ').map(Number);

let [rh, rm] = [0, 0];

if(m>=45) {
    rh = h;
    rm = m-45;
} else {
    if(h>0) {
        rh = h-1;
        rm = 60-45+m;
    } else if(h==0) {
        rh = 23;
        rm = 60-45+m
    }
}
console.log(rh, rm);
