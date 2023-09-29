package com.example.assign2.TransposeMatrix;

import org.springframework.stereotype.Service;

@Service
public class MatrixTransposeService {
    public static int[][] toMatrix(String n1, String n2, String n3, String n4){
        int[][] matrix = new int[2][2];
        matrix[0][0] = Integer.parseInt(n1);
        matrix[0][1] = Integer.parseInt(n2);
        matrix[1][0] = Integer.parseInt(n3);
        matrix[1][1] = Integer.parseInt(n4);
        return matrix;
    }
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] transpose = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
