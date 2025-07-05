/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const result = []
    function fatten(arr, depth){
        for(const item of arr){
            if(typeof item === 'object' && depth < n){
                fatten(item, depth+1);
            }else{
                result.push(item);
            }
        }
        return result;
    }

    return fatten(arr, 0);
    
};