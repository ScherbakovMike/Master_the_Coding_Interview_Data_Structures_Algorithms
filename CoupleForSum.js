function coupleForSum_naive(array, sum) {
    let result = false;
    array.every((n, i) => {
        array.every((m, j) => {
            if ((i !== j) && ((n + m) === sum)) {
                result = true;
                return false;
            } else {
                return true;
            }
        })
        return !(result);
    });
    return result;
}

function coupleForSum_complements(array, sum) {
    let result = false;
    const complements = new Set()
    for(const element of array) {
        const complement = sum - element;
        if(complements.has(complement)) {
            return true;
        }
        complements.add(element);
    }
    return result;
}

const array = Array.from(Array(10000).keys());
console.time("Naive")
console.log(coupleForSum_naive(array, 19997));
console.timeEnd("Naive")
console.time("Complements")
console.log(coupleForSum_complements(array, 19997));
console.timeEnd("Complements")