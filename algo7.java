import java.util.Arrays;

void main() {
    printLongestStraightLine(
            new int[]{2, 2},
            new int[]{1, 1},
            new int[]{2, 1},
            new int[]{3, 3},
            new int[]{4, 4},
            new int[]{1, 3});
    printLongestStraightLine(new int[]{0, 0},
            new int[]{1, 3},
            new int[]{1, 2},
            new int[]{2, 4}, new int[]{2, 2},
            new int[]{3, 1}, new int[]{4, 0});
}

void printLongestStraightLine(int[]... coordinatesPairs) {
    int[][] pairs = new int[2][2];
    int max = 0;
    int distance, indexofpair1 = 0, indexOfPair2 = 0;
    for (int i = 0; i < coordinatesPairs.length; i++) {
        for (int j = coordinatesPairs.length - 1; j > i; j--) {
            distance = (coordinatesPairs[i][0] - coordinatesPairs[j][0]) * (coordinatesPairs[i][0] - coordinatesPairs[j][0])
                    + (coordinatesPairs[i][1] - coordinatesPairs[j][1]) * (coordinatesPairs[i][1] - coordinatesPairs[j][1]);
            if (max < distance) {
                max = distance;
                pairs[0] = coordinatesPairs[i];
                pairs[1] = coordinatesPairs[j];
                indexofpair1 = i;
                indexOfPair2 = j;
            }
        }
    }
    //System.out.println("distance = " + max);
    System.out.println("longest distance cordinates = " + Arrays.toString(pairs[0]) + Arrays.toString(pairs[1]) + " ");

    //find intermediate coordinates m=y/x
    float mPresent = (float)(pairs[0][1] - pairs[1][1]) / (pairs[0][0] - pairs[1][0]);
    float m;
    System.out.print("Coordinates in line = ");
    for (int i = 0; i < coordinatesPairs.length; i++) {
        if (indexofpair1 != i || indexOfPair2 != i) {

            int mx=(coordinatesPairs[i][0] - pairs[1][0])==0?(coordinatesPairs[i][0] - pairs[0][0]):(coordinatesPairs[i][0] - pairs[1][0]);
            int my=(coordinatesPairs[i][0] - pairs[1][0])==0?(coordinatesPairs[i][1] - pairs[0][1]):(coordinatesPairs[i][1] - pairs[1][1]);

            m = (float) my / mx;
            if (mPresent==m) {
                System.out.print(Arrays.toString(coordinatesPairs[i]) + " ");
            }
        }
    }
    System.out.println(" \n");
}
