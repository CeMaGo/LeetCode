var isValid = function(s) {
    let stack = [];
    let map = { ')': '(', '}': '{', ']': '['};

    for(let char of s) {
        if (char in map) {
            let top = stack.pop();
            if (top !== map[char]) 
                return false;
        } else {
            stack.push(char);
        }
    }
    return stack.length === 0;
}