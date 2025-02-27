var romanToInt = function(s) {
    // Step 1: Create a map of Roman numeral values

    const romanMap = {
        'I': 1,'V': 5,'X': 10,'L': 50, 
        'C': 100, 'D': 500, 'M': 1000
    };

    let total = 0; // Store the final number
    let prev = 0;  // Store the previous numeral value

    //-------------->>> Step 2 <<<----------------\\

    // Iterate through the input/string from right to left
    for (let i = s.length - 1; i >= 0; i--) {
        let curr = romanMap[s[i]]; // Get the value of the current numeral

    //-------------->>> Step 3 <<<------------------\\
        if (curr < prev) {
            total -= curr;
        } else {
            total += curr;
        }
    //-------------->>> Step 4 <<<-------------------\\
    // Update previous value for the next iteration
    prev = curr;
    }
    return total; // Return the final integer
}