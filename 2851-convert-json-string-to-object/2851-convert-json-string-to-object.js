/**
 * @param {string} str
 * @return {null|boolean|number|string|Array|Object}
 */
var jsonParse = function(str) {
    let i =0;

    function parseValue(){
        if(str[i] === '"') return parseString();
        if(str[i] ==='-' || isDigit(str[i])) return parseNumber();
        if(str[i] === 't') return parseLiteral("true", true);
        if(str[i] === 'f') return parseLiteral("false", false);
        if(str[i] === 'n') return parseLiteral("null", null);
        if(str[i] === '[') return parseArray();
        if(str[i] === '{') return parseObject();
        throw new Error("invalid Json at " + i);
    }

    function parseString(){
        i++; //skip opening quote
        let result = '';
        while(str[i] != '"'){
            result += str[i];
            i++;
        }
        i++; // skip closing quote
        return result;
    }

    function parseNumber(){
        let start = i;
        if(str[i] === '-') i++; // negative
        while(isDigit(str[i])) i++;
        if(str[i] === '.'){// decimal
            i++;
            while(isDigit(str[i])) i++;
        }
        return Number(str.slice(start, i));
    }

    function parseLiteral(keyword, value){
        if(str.slice(i, i+keyword.length) === keyword){
            i += keyword.length;
            return value;
        }
        throw new Error("unexpected token at "+i);
    }

    function parseArray(){
        i++; //skip '['
        const result = [];
        if(str[i] === ']'){
            i++;
            return result;
        }
        while(true){
            result.push(parseValue());
            if(str[i] === ']'){
                i++;
                break;
            }
            if(str[i] === ',') i++;
        }
        return result;
    }

  function parseObject(){
        i++; //skip '{'
        const result = {};
        if(str[i] === '}'){
            i++;
            return result;
        }
        while(true){
           const key = parseString();
           i++;
           const value = parseValue();
           result[key] = value;
           if(str[i] === '}'){
            i++;
            break;
           }
           if(str[i] === ',') i++;
        }
        return result;
    }

    function isDigit(ch) {
        return ch >= '0' && ch <= '9';
    }

    return parseValue();
    
};