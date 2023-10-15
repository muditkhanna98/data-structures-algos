package matrix;

public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

        searchElementInRowAndColumnSortedMatrix(arr, 11);
    }

    private static void matrixInSnake(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < arr[i].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = arr[i].length - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println(" ");
        }
    }

    private static void boundaryTraversal(int[][] arr) {
        if (arr.length == 1) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[0][j] + " ");
            }
        } else if (arr[0].length == 1) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i][0]);
            }
        } else {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.println(arr[0][j]);
            }
            System.out.println(" ");
            for (int i = 1; i < arr.length; i++) {
                System.out.println(arr[i][arr[0].length - 1]);
            }
            System.out.println(" ");
            for (int j = arr[0].length - 2; j >= 0; j--) {
                System.out.println(arr[arr.length - 1][j] + " ");
            }
            System.out.println(" ");
            for (int i = arr.length - 2; i >= 1; i--) {
                System.out.println(arr[i][0]);
            }
        }
    }

    /*idea is that the diagonal elements stay the same, we swap the upper diagonal
    elements with the lower diagonal elements*/
    private static void transposeOfMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    /*idea is to first find the transpose of the matrix and then reverse the rows which means first row
    becomes the last row, second row becomes the second last row and so on*/
    private static void rotate90AntiClockWise(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }

        for (int j = 0; j < arr[0].length; j++) {
            int low = 0;
            int high = arr.length - 1;

            while (low < high) {
                int temp = arr[low][j];
                arr[low][j] = arr[high][j];
                arr[high][j] = temp;
                low++;
                high--;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    private static void searchElementInRowAndColumnSortedMatrix(int[][] arr, int x) {
        int i = 0;
        int j = arr[0].length - 1;

        while (i < arr.length && j >= 0) {
            if (arr[i][j] == x) {
                System.out.println("Found at " + i + " " + j);
                return;
            } else if (x < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("Not Found");
    }
}
