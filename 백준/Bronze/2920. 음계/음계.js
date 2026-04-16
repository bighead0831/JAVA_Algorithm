const fs = require("fs");
const input = fs.readFileSync(0).toString().trim().split('\n');
const notes = input[0].split(' ').map(Number);

let chkAscend = false;
let chkDescend = false;
for(let i=1; i<notes.length; i++) {
    if(notes[0] === 1) {
        chkAscend = true;
        if(notes[i]-notes[i-1] != 1) {
            chkAscend = false;
            break;
        }
    }
    else if(notes[0] === 8) {
        chkDescend = true;
        if(notes[i]-notes[i-1] != -1) {
            chkDescend = false;
            break;
        }
    } else {
        chkDescend = false;
        chkAscend = false;
        break;
    }
}

if(chkAscend === false && chkDescend === false) {
    console.log("mixed");
} else if(chkAscend === true && chkDescend === false) {
    console.log("ascending");
} else if(chkAscend === false && chkDescend === true) {
    console.log("descending");
}