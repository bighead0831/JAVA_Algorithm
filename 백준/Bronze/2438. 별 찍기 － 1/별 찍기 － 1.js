const fs = require("fs");
const n = Number(fs.readFileSync(0).toString().trim().split('\n'));

for(let i=0; i<n; i++) {
    for(let j=0; j<=i; j++) {
        process.stdout.write("*");
    }
    process.stdout.write("\n");
}