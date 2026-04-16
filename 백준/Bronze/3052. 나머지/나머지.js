const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const nums = input.slice(0).map(Number);

let arr = Array(nums.length).fill(0);
for(let i=0; i<nums.length; i++) {arr[i] = nums[i]%42;}
let diffNums = new Set(arr);

console.log(diffNums.size);