package questions;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class Q19 {

    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> resList = new ArrayList<>();
        //todo
        if(matrix.length == 0) return resList;
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        while(true) {
            for(int i = l; i <= r; i++) resList.add(matrix[t][i]); // left to right.
            if(++t > b) break;
            for(int i = t; i <= b; i++) resList.add(matrix[i][r]); // top to bottom.
            if(l > --r) break;
            for(int i = r; i >= l; i--) resList.add(matrix[b][i]); // right to left.
            if(t > --b) break;
            for(int i = b; i >= t; i--) resList.add(matrix[i][l]); // bottom to top.
            if(++l > r) break;
        }
        return resList;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> list = new Q19().printMatrix(matrix);
        list.stream().forEach(a -> System.out.println(a));
    }

}
