/**
 * @param {Function[]} functions
 * @param {number} n
 * @return {Promise<any>}
 */
var promisePool = async function(functions, n) {
    let i = 0;

    const next = async() =>{
        if(i>= functions.length) return;
        const fn = functions[i++];
        await fn(); //await until fn resolves
        await next(); // pick the next function
    }

    const workers = Array(n).fill(0).map(() => next());
    await Promise.all(workers);

    
};

/**
 * const sleep = (t) => new Promise(res => setTimeout(res, t));
 * promisePool([() => sleep(500), () => sleep(400)], 1)
 *   .then(console.log) // After 900ms
 */