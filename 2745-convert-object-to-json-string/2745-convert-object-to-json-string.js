/**
 * @param {null|boolean|number|string|Array|Object} object
 * @return {string}
 */
var jsonStringify = function(object) {
    if(object === null || object === undefined) return "null";

    const type = typeof object;

    if(type === "number" || type === "boolean"){
        return String(object);
    }

    if(type === "string"){
        return `"${object}"`;
    }

    if(Array.isArray(object)){
        const elements = object.map(item => jsonStringify(item));
        return `[${elements.join(",")}]`;
    }

    if(type === "object"){
        const keys = Object.keys(object);
        const keyValPair = keys.map(key => `"${key}":${jsonStringify(object[key])}`);
        return `{${keyValPair.join(",")}}`;
    }
    
};