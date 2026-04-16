const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const nums = input.slice(0);

for(let i=0; i<nums.length; i++) {
    let n = nums[i].split(' ').map(Number);
    console.log(n[0]+n[1]);
}