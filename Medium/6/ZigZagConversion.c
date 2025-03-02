
char* convert(char* s, int numRows) {
    int len = strlen(s);
    if (numRows == 1 || len <= numRows) {
        return strdup(s);
    }

    char* result = (char*)malloc((len + 1) * sizeof(char));
    int resultIndex = 0;


    for (int row = 0; row < numRows; row++){
        int currentIndex = row;
        int step1 = 2 * (numRows - 1 - row);
        int step2 = 2 * row;
        int useStep1 = 1;

        while (currentIndex < len) {
            result[resultIndex++] = s[currentIndex];

            if ( row == 0 || row == numRows - 1) {
                currentIndex += step1 > 0 ? step1 : step2;
            } else {
                if (useStep1 && step1 > 0) {
                    currentIndex += step1;
                } else if (!useStep1 && step1 > 0) {
                    currentIndex += step2;
                }
                useStep1 = !useStep1;                
            }
        }
    }

    result[resultIndex] = '\0';
    return result;
}