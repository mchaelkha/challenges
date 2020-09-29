package Codility.Wayfair.Magic;

class Solution {

    // Takes the entire 2d array and a magic square size

    // Work from the top-left corner to the bottom-right corner with the size bounding
    // Return the size if found; otherwise 0
    public int getMagicSquareSize(int[][] a, int size) {
        // Upper bounds this function will check; add 1 to fix bounds
        int rowBound = a.length - size + 1;
        int colBound = a[0].length - size + 1;
        // Default to 0
        int result = 0;
        // Loop the coordinates up to the bounds; as soon as size is found we return
        for (int y = 0; y < rowBound; y++) {
            // The starting top-left coordinate
            for (int x = 0; x < colBound; x++) {
                int rowSum, colSum, diagSum;
                rowSum = colSum = diagSum = 0;
                // Time to sum the rows, cols, and diags
                for (int i = 0; i < size; i++) {
                    rowSum += a[y][x + i];
                    colSum += a[y + i][x];
                    diagSum += a[y + i][x + i];
                }
                // If sums are equal return the size
                if (rowSum == colSum && diagSum == rowSum) {
                    return size;
                }
            }
        }
        // No solution found; return the default result
        return result;
    }

    // Assume that the array a is non-empty
    // return the size of the largest magic square found
    public int solution(int[][] a) {
        // write your code in Java SE 8
        int rows = a.length;
        int columns = a[0].length;
        // Magic squares of size 1
        if (rows == 1 && columns == 1) {
            return 1;
        }
        // Max possible size
        int max = rows > columns ? columns : rows;
        int largestSize = 1;
        int current = 1;
        // Start checking for size 2 magic squares in a sliding window manner via getMagicSquareSize
        for (int size = 2; size <= max; size++) {
            current = getMagicSquareSize(a, size);
            if (current > largestSize) {
                largestSize = current;
            }
        }

        return largestSize;
    }
}

