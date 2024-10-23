public class SkyView {
    private final double[][] view;

    public SkyView(int numRows, int numCols, double[] scanned) {
        view = new double[numRows][numCols];
        int idxScanned = 0;
        boolean isLeft = true;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (isLeft) {
                    view[i][j] = scanned[idxScanned];
                } else {
                    view[i][numCols - j - 1] = scanned[idxScanned];
                }
                idxScanned++;
            }
            isLeft = !isLeft;
        }
    }

    public double getAverage(int startRow, int endRow, int startCol, int endCol) {
        double result = 0;
        for(int i=startRow; i<=endRow; i++) {
            for(int j=startCol; j<=endCol; j++) {
                result += view[i][j];
            }
        }
        int cnt = (endRow - startRow + 1) * (endCol - startCol + 1);
        return result / cnt;
    }

    public void print() {
        for (double[] doubles : view) {
            for (double aDouble : doubles) {
                System.out.print(aDouble + " ");
            }
            System.out.println();
        }
    }
}
