/**
 * @param {number[]} arr
 * @return {number}
 */
var findLucky = function(arr) {
    const freq = new Map();
    for(let n of arr){
        freq.set(n, (freq.get(n)|| 0) +1);
    }

    let result = -1;
    for(let [n, f] of freq.entries()){
        if(n === f){
            result = Math.max(result, n);
        }
    }
    return result;
};