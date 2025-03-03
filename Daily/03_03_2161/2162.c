
int* pivotArray(int* nums, int numsSize, int pivot, int* returnSize) {
    int* less = (int*)malloc(numsSize * sizeof(int));
    int* equal = (int*)malloc(numsSize * sizeof(int));
    int* greater = (int*)malloc(numsSize * sizeof(int));

    int lessSize = 0, equalSize = 0, greaterSize = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] < pivot) {
            less[lessSize++] = nums[i];
        } else if (nums[i] == pivot) {
            equal[equalSize++] = nums[i];
        } else {
            greater[greaterSize++] = nums[i];
        }
    }

    int* result = (int*)malloc(numsSize * sizeof(int));
    int resultSize = 0;

    for (int i = 0; i < lessSize; i++) {
        result[resultSize++] = less[i];
    }
    for (int i = 0; i < equalSize; i++) {
        result[resultSize++] = equal[i];
    }
    for (int i = 0; i < greaterSize; i++) {
        result[resultSize++] = greater[i];
    }

    free(less);
    free(equal);
    free(greater);

    *returnSize = resultSize;
    return result;
}