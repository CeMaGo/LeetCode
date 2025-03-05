#include <stdint.h>

int64_t coloredCells(int n) {
    return 1LL + 2LL * (int64_t) n * (n - 1LL);
}