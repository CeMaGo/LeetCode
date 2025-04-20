/**
 * @param {number[]} answers
 * @return {number}
 */
var numRabbits = function (answers) {
  if (!answers || answers.length === 0) {
    return 0;
  }

  const counts = new Map();
  for (const answer of answers) {
    counts.set(answer, (counts.get(answer) || 0) + 1);
  }

  let minRabbits = 0;
  for (const [reportedCount, numRabbitsWithSameAnswer] of counts.entries()) {
    const groupSize = reportedCount + 1;
    const numFullGroups = Math.floor(numRabbitsWithSameAnswer / groupSize);
    const remainingRabbits = numRabbitsWithSameAnswer % groupSize;

    minRabbits += numFullGroups * groupSize;
    if (remainingRabbits > 0) {
      minRabbits += groupSize;
    }
  }

  return minRabbits;
};
