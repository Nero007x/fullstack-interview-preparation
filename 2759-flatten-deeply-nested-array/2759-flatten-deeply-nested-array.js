/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    const result = [];
    function flatten(arr, depth){
        for(const item of arr){
            if(Array.isArray(item) && depth< n){
                flatten(item, depth+1);
            }else{
                result.push(item);
            }
        }
        return result;
    }

    return flatten(arr, 0);
    
};