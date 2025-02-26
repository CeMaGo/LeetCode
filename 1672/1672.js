/**
 * @param {number[][]} accounts
 * @return {number}
 */
var maximumWealth = function(accounts) {
    let maxWealthSoFar = 0;

    for (let customer of accounts) {
        let currentCostumerWealth = customer.reduce((sum, bank) => sum + bank, 0);
        maxWealthSoFar = Math.max(maxWealthSoFar, currentCostumerWealth);
    }

    return maxWealthSoFar;
};