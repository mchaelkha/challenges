'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}



/*
 * Complete the 'minimumChunksRequired' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. LONG_INTEGER totalPackets
 *  2. 2D_LONG_INTEGER_ARRAY uploadedChunks
 */

function minimumChunksRequired(totalPackets, uploadedChunks) {
    // Write your code here
    let result = 0
    let power = 1
    while (power*2 < totalPackets) {
        power *= 2
    }

    return result
}

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const totalPackets = parseInt(readLine().trim(), 10);

    const uploadedChunksRows = parseInt(readLine().trim(), 10);

    const uploadedChunksColumns = parseInt(readLine().trim(), 10);

    let uploadedChunks = Array(uploadedChunksRows);

    for (let i = 0; i < uploadedChunksRows; i++) {
        uploadedChunks[i] = readLine().replace(/\s+$/g, '').split(' ').map(uploadedChunksTemp => parseInt(uploadedChunksTemp, 10));
    }

    const result = minimumChunksRequired(totalPackets, uploadedChunks);

    ws.write(result + '\n');

    ws.end();
}
