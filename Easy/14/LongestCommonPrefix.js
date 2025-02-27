var longestCommonPrefix = function(strs) {
    if(!strs.length) return ""; // Edge case: empty list

    //----------------------->>> Step 1 <<<-----------------------\\ Sort array

    strs.sort();

    //----------------------->>> Step 2 <<<------------------------\\ Compare first and last word / most Different

    let first = strs[0];
    let last = strs[strs.length - 1];
    let i = 0;

    //----------------------->>> Step 3 <<<-------------------------\\ Find Common Prefix between first and last word

    while (i < first.length && first[i] === last[i]) {
        i++;
    }

    return first.substring(0, i);
}